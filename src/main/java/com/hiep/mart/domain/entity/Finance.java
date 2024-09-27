package com.hiep.mart.domain.entity;

import java.time.LocalDate;
import java.util.Set;

import com.hiep.mart.domain.enumeration.TypeOfTransaction;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "finance")
public class Finance {
    @Id
    @SequenceGenerator(name = "finance_sequence", sequenceName = "finance_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "finance_sequence")
    @Column(name = "finance_id")
    Long financeId;
    @Column(name = "transaction_date")
    LocalDate transactionDate;
    @Column(name = "transaction_price")
    Double transactionPrice;
    @Column(name = "type_of_transaction")
    TypeOfTransaction typeOfTransaction;
}
