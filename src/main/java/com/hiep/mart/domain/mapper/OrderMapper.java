package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.entity.Orders;
import com.hiep.mart.domain.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Orders toOrder(OrderRequest orderRequest);
    OrderDTO toOrderDTO(Orders orders);
    void updateOrder(@MappingTarget Orders orders, OrderRequest orderRequest);
}
