package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PaymentResponseDTO {
    String orderCode;
    LocalDate paymentDate;
    String amount;
    Long customerId;
}
