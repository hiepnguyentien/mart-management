package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AdministrativeRegionDTO {
    Integer id;
    String name;
    String nameEn;
    String codeName;
    String codeNameEn;
}
