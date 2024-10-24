package com.hiep.mart.service;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.dto.ProductCartDTO;
import com.hiep.mart.domain.request.CartRequest;

import java.util.List;
import java.util.Locale;

public interface CartService {
    CartDTO addToCart(CartRequest request, String authorizationHeader, Locale locale);
    Long quantityInCart(Long productId, String authorizationHeader);
    void removeFromCart(Long productId, String authorizationHeader, Locale locale);
    CartDTO updateCart(CartRequest request, String authorizationHeader, Locale locale);
    void clearCart();
    List<ProductCartDTO> viewCart(String authorizationHeader);
}
