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
public class ProductRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String productCode;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String productName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    @Min(value = 1, message = "QUANTITY_MUST_GREATER_THAN_ZERO")
    Double productPrice;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String productUnit;
    String productDescription;
    String productImage;
    String productStatus;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String productBrand;
    Long inventoryQuantity;
    Long supplierId;
    String information;
}
