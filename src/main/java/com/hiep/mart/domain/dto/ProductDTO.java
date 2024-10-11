package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductDTO {
    Long productId;
    String productCode;
    String productName;
    Double productPrice;
    String productUnit;
    String productDescription;
    String productImage;
    String productStatus;
    String productBrand;
    Long inventoryQuantity;
    Long supplierId;
    String supplierName;
    String information;
    Double discountPercentage;
    Double discountAmount;
    Double promotionalPrice;

    public Double getPromotionalPrice() {
        if (getDiscountAmount() == null)
            return getProductPrice();
        return getProductPrice() - getProductPrice()*getDiscountAmount()/100;
    }
}
