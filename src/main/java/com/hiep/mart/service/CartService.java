package com.hiep.mart.service;

public interface CartService {
    void addToCart(Long userId, Long productId, Long quantity);
    void removeFromCart(Long productId);
    void updateCart(Long productId, Long quantity);
    void clearCart();
    void viewCart();
}
