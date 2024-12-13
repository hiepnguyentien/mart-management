package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.dto.PurchasedProductDTO;
import com.hiep.mart.domain.mapper.OrderDetailMapper;
import com.hiep.mart.domain.request.OrderDetailRequest;
import com.hiep.mart.repository.OrderDetailRepository;
import com.hiep.mart.service.OrderDetailService;
import com.hiep.mart.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailMapper orderDetailMapper;
    OrderDetailRepository orderDetailRepository;
    AuthenticationService authenticationService;

    @Override
    public List<OrderDetailDTO> viewOrderDetail(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId)
                .stream()
                .map(orderDetailMapper::toOrderDetailDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addToOrderDetail(OrderDetailRequest request) {
        orderDetailRepository.save(orderDetailMapper.toOrderDetail(request));
    }

    @Override
    @PreAuthorize("hasAuthority('GET_PRODUCT_PURCHASED')")
    public List<PurchasedProductDTO> getProductsPurchased(String authorizationHeader) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        Long customerId = authenticationService.getCustomerIdFromUserId(userId);
        return new ArrayList<>(orderDetailRepository.findByCustomerId(customerId));
    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public void viewOrderStatus(Long orderId) {

    }

    @Override
    public void viewOrderInvoice(Long orderId) {

    }

    @Override
    public void viewOrderReceipt(Long orderId) {

    }
}
