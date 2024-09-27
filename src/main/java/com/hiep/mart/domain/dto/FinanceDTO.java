package com.hiep.mart.domain.dto;

import com.hiep.mart.domain.enumeration.TypeOfTransaction;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class FinanceDTO {
    Long financeId;
    LocalDate transactionDate;
    Double transactionPrice;
    TypeOfTransaction typeOfTransaction;
}
