package com.hiep.mart.domain.dto;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class BatchDTO {
    Long batchId;
    Long batchQuantity;
    Double batchPrice;
    LocalDate importDate;
    LocalDate expiredDate;
    String batchStatus;
    Long productId;
}
