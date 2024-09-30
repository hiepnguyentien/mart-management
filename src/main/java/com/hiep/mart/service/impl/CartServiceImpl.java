package com.hiep.mart.service.impl;

import org.springframework.stereotype.Service;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.entity.Cart;
import com.hiep.mart.domain.mapper.CartMapper;
import com.hiep.mart.domain.request.CartRequest;
import com.hiep.mart.repository.CartRepository;
import com.hiep.mart.service.CartService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    CartMapper cartMapper;

    @Override
    public void addToCart(Long userId, Long productId, Long quantity) {
        CartRequest request = CartRequest.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();
        Cart cart = cartMapper.toCart(request);
        cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFromCart'");
    }

    @Override
    public void updateCart(Long productId, Long quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCart'");
    }

    @Override
    public void clearCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearCart'");
    }

    @Override
    public void viewCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewCart'");
    }
    
}
