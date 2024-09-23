package com.hiep.mart.domain.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class SupplierDTO {
    Long supplierId;
    String supplierName;
    String supplierAddress;
    String supplierPhone;
    String supplierEmail;
    String supplierStatus;
}
