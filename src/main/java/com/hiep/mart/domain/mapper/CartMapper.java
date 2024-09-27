package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.CartDTO;
import com.hiep.mart.domain.entity.Cart;
import com.hiep.mart.domain.request.CartRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface CartMapper {
    @Mapping(source = "productId", target = "products.productId")
    @Mapping(source = "customerId", target = "customers.customerId")
    Cart toCart(CartRequest cartRequest);

    @Mapping(source = "products.productId", target = "productId")
    @Mapping(source = "customers.customerId", target = "customerId")
    CartDTO toCartDTO(Cart cart);

    void updateCart(@MappingTarget Cart cart, CartRequest cartRequest);

}
