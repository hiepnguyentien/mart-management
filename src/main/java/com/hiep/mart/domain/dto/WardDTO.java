package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class WardDTO {
    String code;
    String name;
    String nameEn;
    String fullName;
    String fullNameEn;
    String codeName;
    String districtCode;
    Integer administrativeUnitId;
}
