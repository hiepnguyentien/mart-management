package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.dto.PaymentResponseDTO;
import com.hiep.mart.domain.dto.ProductCartDTO;
import com.hiep.mart.domain.enumeration.TypeOfTransaction;
import com.hiep.mart.domain.request.FinanceRequest;
import com.hiep.mart.domain.request.OrderDetailRequest;
import com.hiep.mart.domain.request.OrderRequest;
import com.hiep.mart.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService {
    private final AuthenticationService authenticationService;
    private final CartService cartService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final FinanceService financeService;
    private final ProductService productService;

    public PaymentResponseDTO handleTransaction(String authorizationHeader, String amount, String bankCode, String orderInfo, String responseCode) {
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        if (!"00".equals(responseCode)) {
            throw new RuntimeException("Fail to handle transaction");
        }

        try {
            Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
            Long customerId = authenticationService.getCustomerIdFromUserId(userId);
            List<ProductCartDTO> cartItems = cartService.viewCart(authorizationHeader);
            OrderDTO orderDTO = createOrder(customerId);
            Double total = processOrderDetails(cartItems, orderDTO);
            updateOrderTotal(orderDTO, total);
            addFinanceRecord(total);
            cartService.clearCart(authorizationHeader);
            paymentResponseDTO.setPaymentDate(LocalDate.now());
            paymentResponseDTO.setAmount(amount.substring(0, amount.length() - 2));
            paymentResponseDTO.setCustomerId(customerId);
            paymentResponseDTO.setOrderCode(orderDTO.getOrderCode());
        } catch (Exception e) {
            throw new RuntimeException("Fail to handle transaction");
        }
        return paymentResponseDTO;
    }

    private OrderDTO createOrder(Long customerId) {
        OrderRequest request = new OrderRequest();
        request.setCustomerId(customerId);
        request.setOrderDate(LocalDate.now());
        request.setOrderStatus("Active");
        request.setOrderCode("#" + LocalTime.now());
//        request.setNote();
//        request.setPaymentMethod();
//        request.setAddress();
//        request.setDeliveryDate();
//        request.setDeliveryTime();
//        request.setPhoneNumber();
        return orderService.addOrder(request);
    }

    private Double processOrderDetails(List<ProductCartDTO> cartItems, OrderDTO orderDTO) {
        Double total = 0D;
        for (ProductCartDTO productCartDTO : cartItems) {
            OrderDetailRequest orderDetailRequest = new OrderDetailRequest();
            orderDetailRequest.setProductId(productCartDTO.getProductId());
            orderDetailRequest.setOrderId(orderDTO.getOrderId());
            orderDetailRequest.setOrderDetailQuantity(productCartDTO.getQuantity());
            orderDetailRequest.setOrderDetailPrice(productCartDTO.getPromotionalPrice());
            total += productCartDTO.getPromotionalPrice() * productCartDTO.getQuantity();
            orderDetailService.addToOrderDetail(orderDetailRequest);
            productService.decreaseProductQuantity(productCartDTO.getProductId(), productCartDTO.getQuantity());
        }
        total += 3000D;
        return total;
    }

    private void updateOrderTotal(OrderDTO orderDTO, Double total) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderTotal(total);
        orderRequest.setCustomerId(orderDTO.getCustomerId());
        orderRequest.setOrderDate(orderDTO.getOrderDate());
        orderRequest.setOrderStatus(orderDTO.getOrderStatus());
        orderRequest.setOrderCode(orderDTO.getOrderCode());
        orderService.updateOrder(orderDTO.getOrderId(), orderRequest);
    }

    private void addFinanceRecord(Double total) {
        FinanceRequest financeRequest = new FinanceRequest();
        financeRequest.setTypeOfTransaction(TypeOfTransaction.THU);
        financeRequest.setTransactionDate(LocalDate.now());
        financeRequest.setTransactionPrice(total);
        financeService.addFinance(financeRequest);
    }
}
