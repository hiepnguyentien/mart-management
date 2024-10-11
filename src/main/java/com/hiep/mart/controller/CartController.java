package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.request.CartRequest;
import com.hiep.mart.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartService cartService;

    @PostMapping("/add-to-cart")
    public CartDTO addToCart(@RequestBody CartRequest request) {
        return cartService.addToCart(request);
    }



}
