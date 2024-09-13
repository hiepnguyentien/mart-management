package com.hiep.mart.domain.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductRequest {
    String code;
    String name;
    Double price;
    String description;
    String image;
    String status;
    String brand;
    Long inventoryQuantity;
    Long categoryId;
    Long supplierId;
    Long batchId;
}
