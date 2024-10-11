package com.hiep.mart.service.impl;

import com.hiep.mart.service.UserService;
import org.springframework.security.access.prepost.PostAuthorize;
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
    UserService userService;

    @Override
    @PostAuthorize("returnObject.userId == authentication.userId")
    public CartDTO addToCart(CartRequest request) {
        Long userId = userService.getCurrentUserId();
        request.setUserId(userId);
        Cart cart = cartMapper.toCart(request);
        cartRepository.save(cart);
        return cartMapper.toCartDTO(cart);
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
