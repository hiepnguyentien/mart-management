package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.entity.Orders;
import com.hiep.mart.domain.mapper.OrderMapper;
import com.hiep.mart.domain.request.OrderRequest;
import com.hiep.mart.repository.OrderRepository;
import com.hiep.mart.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    @Override
    public List<OrderDTO> viewAllOrder() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> viewOrderByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO addOrder(OrderRequest request) {
        Orders orders = orderMapper.toOrder(request);
        orderRepository.save(orders);
        return orderMapper.toOrderDTO(orders);
    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public void viewOrderStatus() {

    }

    @Override
    public void viewOrderInvoice() {

    }

    @Override
    public void viewOrderReceipt() {

    }
}
