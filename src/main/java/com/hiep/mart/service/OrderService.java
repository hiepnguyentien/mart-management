package com.hiep.mart.service;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<OrderDTO> viewAllOrder();
    List<OrderDTO> viewOrderByCustomerId(Long customerId);
    OrderDTO addOrder(OrderRequest request);
    void updateOrder();
    void cancelOrder();
    void viewOrderStatus();
    void viewOrderInvoice();
    void viewOrderReceipt();
}
