package com.hiep.mart.service;

public interface OrderDetailService {
    void viewOrderDetail(Long orderId);
    void cancelOrder(Long orderId);
    void viewOrderStatus(Long orderId);
    void viewOrderInvoice(Long orderId);
    void viewOrderReceipt(Long orderId);
}
