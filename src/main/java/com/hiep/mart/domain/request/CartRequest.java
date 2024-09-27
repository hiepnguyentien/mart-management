package com.hiep.mart.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class CartRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    @Min(value = 1, message = "QUANTITY_MUST_GREATER_THAN_ZERO")
    Long quantity;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long customerId;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long productId;
}
