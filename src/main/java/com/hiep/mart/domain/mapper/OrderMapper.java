package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.entity.Orders;
import com.hiep.mart.domain.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "customerId", target = "customers.customerId")
    Orders toOrder(OrderRequest orderRequest);
    @Mapping( target = "customerId", source = "customers.customerId")
    OrderDTO toOrderDTO(Orders orders);
    void updateOrder(@MappingTarget Orders orders, OrderRequest orderRequest);
}
