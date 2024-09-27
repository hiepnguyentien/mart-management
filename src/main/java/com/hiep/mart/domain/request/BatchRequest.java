package com.hiep.mart.domain.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class BatchRequest {
    @NotNull(message = "Batch quantity cannot be null")
    @Min(value = 1, message = "Batch quantity must be greater than 0")
    Long batchQuantity;
    @NotNull(message = "Batch price cannot be null")
    @Min(value = 0, message = "Batch price must be greater than or equal to 0")
    Double batchPrice;
    LocalDate importDate;
    @NotNull(message = "Expired date cannot be null")
    @Future(message = "Expired date must be in the future")
    LocalDate expiredDate;
    String batchStatus;
    Long productId;
}
