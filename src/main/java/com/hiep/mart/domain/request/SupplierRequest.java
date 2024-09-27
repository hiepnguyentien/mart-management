package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class SupplierRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String supplierName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String supplierAddress;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String supplierPhone;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String supplierEmail;
    String supplierStatus;
}
