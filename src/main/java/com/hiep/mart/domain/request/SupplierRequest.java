package com.hiep.mart.domain.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class SupplierRequest {
    String supplierName;
    String supplierAddress;
    String supplierPhone;
    String supplierEmail;
    String supplierStatus;
}
