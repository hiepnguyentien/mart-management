package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductDTO {
    Long id;
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
