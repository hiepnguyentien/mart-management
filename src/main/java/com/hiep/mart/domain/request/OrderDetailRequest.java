package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OrderDetailRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long orderDetailQuantity;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Double orderDetailPrice;
    String orderDetailStatus;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long orderId;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long productId;
}
