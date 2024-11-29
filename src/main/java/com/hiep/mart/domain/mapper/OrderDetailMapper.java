package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.entity.OrderDetail;
import com.hiep.mart.domain.request.OrderDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    @Mapping(source = "orderId", target = "orders.orderId")
    @Mapping(source = "productId", target = "products.productId")
    OrderDetail toOrderDetail(OrderDetailRequest orderDetailRequest);
    @Mapping(target = "orderId", source = "orders.orderId")
    @Mapping(target = "productId", source = "products.productId")
    OrderDetailDTO toOrderDetailDTO(OrderDetail orderDetail);
    void updateOrderDetail(@MappingTarget OrderDetail orderDetail, OrderDetailRequest orderDetailRequest);
}
