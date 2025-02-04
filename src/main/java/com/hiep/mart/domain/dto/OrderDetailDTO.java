package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OrderDetailDTO {
    Long orderDetailId;
    Long orderDetailQuantity;
    Double orderDetailPrice;
    String orderDetailStatus;
    Long orderId;
    Long productId;
}
