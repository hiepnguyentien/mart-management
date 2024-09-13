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
    Long id;

    String name;
    String description;

    double discountPercentage; 
    double discountAmount;

    @Enumerated(EnumType.STRING)
    PromotionType promotionType; 

    LocalDate startDate; 
    LocalDate endDate; 

    int minimumQuantity; 

    @ManyToMany
    Set<Products> products;
}
