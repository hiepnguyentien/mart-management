package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductCartDTO {
    Long productId;
    String productName;
    String productUnit;
    String productImage;
    String productStatus;
    String productBrand;
    Double productPrice;
    Double discountPercentage;
    Double discountAmount;
    Double promotionalPrice;
    Long quantity;
    Long userId;

    public Double getPromotionalPrice() {
        if (getDiscountAmount() == null)
            return getProductPrice();
        return getProductPrice() - getProductPrice() * getDiscountAmount() / 100;
    }
}
