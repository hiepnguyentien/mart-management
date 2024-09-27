package com.hiep.mart.domain.request;

import com.hiep.mart.domain.enumeration.TypeOfTransaction;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class FinanceRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    LocalDate transactionDate;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    Double transactionPrice;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    TypeOfTransaction typeOfTransaction;
}
