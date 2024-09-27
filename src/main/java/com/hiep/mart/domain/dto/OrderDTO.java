package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OrderDTO {
    Long orderId;
    String orderCode;
    LocalDate orderDate;
    String orderStatus;
    Double orderTotal;
    Long customerId;
}
