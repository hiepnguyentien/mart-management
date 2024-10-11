package com.hiep.mart.service;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.request.CartRequest;

public interface CartService {
    CartDTO addToCart(CartRequest request);
    void removeFromCart(Long productId);
    void updateCart(Long productId, Long quantity);
    void clearCart();
    void viewCart();
}
