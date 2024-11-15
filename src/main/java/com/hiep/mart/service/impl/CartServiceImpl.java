package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.ProductCartDTO;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    CartMapper cartMapper;
    UserService userService;
    AuthenticationService authenticationService;
    MessageSource messageSource;

    @Override
//    @PostAuthorize("returnObject.userId == authentication.userId")
    @PreAuthorize("hasAuthority('ADD_TO_CART')")
    public CartDTO addToCart(CartRequest request, String authorizationHeader, Locale locale) throws AppException {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        request.setUserId(userId);
        Long productId = request.getProductId();
        Long quantity = cartRepository.countByCustomerId(productId, userId);
        if(quantity != null) {
            throw new AppException(ErrorCode.PRODUCT_ALREADY_EXISTS, messageSource, locale);
        }
        Cart cart = cartMapper.toCart(request);
        cartRepository.save(cart);
        return cartMapper.toCartDTO(cart);
    }

    @Override
    @PreAuthorize("hasAuthority('QUANTITY_IN_CART')")
    public Long quantityInCart(Long productId, String authorizationHeader) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        Long quantity = cartRepository.countByCustomerId(productId, userId);
        if(quantity == null) {
            return 0L;
        }
        else return quantity;
    }

    @Override
    @PreAuthorize("hasAuthority('REMOVE_FROM_CART')")
    public void removeFromCart(Long productId, String authorizationHeader, Locale locale) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        Cart cart = cartRepository.findByCustomerIdAndProductId(userId, productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTS, messageSource, locale));
        cartRepository.delete(cart);
    }

    @Override
    @PreAuthorize("hasAuthority('UPDATE_CART')")
    public CartDTO updateCart(CartRequest request, String authorizationHeader, Locale locale) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        request.setUserId(userId);
        Long productId = request.getProductId();
        Cart cart = cartRepository.findByCustomerIdAndProductId(userId, productId)
                        .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTS, messageSource, locale));
        cartMapper.updateCart(cart, request);
        cartRepository.save(cart);
        return cartMapper.toCartDTO(cart);
    }

    @Override
    @PreAuthorize("hasAuthority('CLEAR_CART')")
    public void clearCart(String authorizationHeader) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        List<Cart> carts = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(carts);
    }

    @Override
    @PreAuthorize("hasAuthority('VIEW_CART')")
    public List<ProductCartDTO> viewCart(String authorizationHeader) {
        Long userId = authenticationService.getUserIdFromToken(authorizationHeader);
        return cartRepository.viewCart(userId);
    }
    
}
