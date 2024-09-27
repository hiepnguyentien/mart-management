package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class CategoryRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String categoryName;
    String categoryDescription;
    String categoryStatus;
}