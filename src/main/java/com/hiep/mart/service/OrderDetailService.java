package com.hiep.mart.service;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.request.OrderDetailRequest;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> viewOrderDetail(Long orderId);
    void addToOrderDetail(OrderDetailRequest request);
    void cancelOrder(Long orderId);
    void viewOrderStatus(Long orderId);
    void viewOrderInvoice(Long orderId);
    void viewOrderReceipt(Long orderId);
}
