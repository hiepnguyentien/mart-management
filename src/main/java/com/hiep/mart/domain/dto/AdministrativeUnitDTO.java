package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AdministrativeUnitDTO {
    Integer id;
    String fullName;
    String fullNameEn;
    String shortName;
    String shortNameEn;
    String codeName;
    String codeNameEn;
}
