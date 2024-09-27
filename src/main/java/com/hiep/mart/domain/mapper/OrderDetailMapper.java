package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.entity.OrderDetail;
import com.hiep.mart.domain.request.OrderDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetail toOrderDetail(OrderDetailRequest orderDetailRequest);
    OrderDetailDTO toOrderDetailDTO(OrderDetail orderDetail);
    void updateOrderDetail(@MappingTarget OrderDetail orderDetail, OrderDetailRequest orderDetailRequest);
}
