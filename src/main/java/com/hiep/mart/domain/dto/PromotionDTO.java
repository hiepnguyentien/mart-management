package com.hiep.mart.domain.dto;

import com.hiep.mart.domain.enumeration.PromotionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PromotionDTO {
    Long id;
    String name;
    String description;
    double discountPercentage;
    double discountAmount;
    PromotionType promotionType;
    LocalDate startDate;
    LocalDate endDate;
    int minimumQuantity;
}
