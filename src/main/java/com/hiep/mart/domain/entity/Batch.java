package com.hiep.mart.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "batch")
public class Batch {
    @Id
    @SequenceGenerator(name = "batch_sequence", sequenceName = "batch_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_sequence")
    @Column(name = "batch_id")
    Long batchId;
    @Column(name = "batch_quantity")
    Long batchQuantity;
    @Column(name = "batch_price")
    Double batchPrice;
    @Column(name = "import_date")
    LocalDate importDate;
    @Column(name = "expired_date")
    LocalDate expiredDate;
    @Column(name = "batch_status")
    String batchStatus;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;
}
