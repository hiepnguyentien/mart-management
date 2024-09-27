package com.hiep.mart.domain.request;

import com.hiep.mart.domain.enumeration.PromotionType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PromotionRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String name;
    String description;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    double discountPercentage;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    double discountAmount;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    PromotionType promotionType;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    LocalDate startDate;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    LocalDate endDate;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    int minimumQuantity;
}
