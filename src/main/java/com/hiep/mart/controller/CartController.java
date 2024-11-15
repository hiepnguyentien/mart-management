package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.dto.ProductCartDTO;
import com.hiep.mart.domain.request.CartRequest;
import com.hiep.mart.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartService cartService;

    @GetMapping("/get-quantity/{productId}")
    public Long getQuantity(@PathVariable("productId") Long productId,
                            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return cartService.quantityInCart(productId, authorizationHeader);
    }

    @GetMapping("view")
    public List<ProductCartDTO> viewCart(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return cartService.viewCart(authorizationHeader);
    }

    @PostMapping("/add-to-cart")
    public CartDTO addToCart(@RequestBody CartRequest request,
                             @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,
                             @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return cartService.addToCart(request, authorizationHeader, locale);
    }

    @PutMapping("/update-cart")
    public CartDTO updateCart(@RequestBody CartRequest request,
                              @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,
                              @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return cartService.updateCart(request, authorizationHeader, locale);
    }

    @DeleteMapping("/delete/{productId}")
    public void removeFromCart(@RequestParam Long productId,
                               @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,
                               @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        cartService.removeFromCart(productId, authorizationHeader, locale);
    }

    @DeleteMapping("/delete-all")
    public void removeAllFromCart(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        cartService.clearCart(authorizationHeader);
    }
}
