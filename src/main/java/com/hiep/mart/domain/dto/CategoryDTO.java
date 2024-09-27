package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class CategoryDTO {
    Long categoryId;
    String categoryName;
    String categoryDescription;
    String categoryStatus;
}
