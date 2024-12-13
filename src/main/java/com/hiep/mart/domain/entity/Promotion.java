package com.hiep.mart.domain.entity;

import java.time.LocalDate;
import java.util.Set;

import com.hiep.mart.domain.enumeration.PromotionType;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    Long promotionId;
    @Column(name = "promotion_name")
    String name;
    @Column(name = "promotion_description")
    String description;
    @Column(name = "discount_percentage")
    double discountPercentage;
    @Column(name = "discount_amount")
    double discountAmount;
    @Column(name = "promotion_type")
    @Enumerated(EnumType.STRING)
    PromotionType promotionType;
    @Column(name = "start_date")
    LocalDate startDate;
    @Column(name = "end_date")
    LocalDate endDate;
    @Column(name = "minimum_quantity")
    int minimumQuantity; 

    @ManyToMany
    Set<Products> products;
}
