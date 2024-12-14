package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OrderRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String orderCode;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    LocalDate orderDate;
    String orderStatus;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Double orderTotal;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Long customerId;
    String address;
    String note;
    String phoneNumber;
    String deliveryDate;
    String deliveryTime;
    String paymentMethod;
}