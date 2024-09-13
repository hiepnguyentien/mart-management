package com.hiep.mart.domain.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @Column(name = "category_id")
    Long categoryId;
    @Column(name = "category_name")
    String categoryName;
    @Column(name = "category_description")
    String categoryDescription;
    @Column(name = "category_status")
    String categoryStatus;

    @ManyToMany
    Set<Products> products;
}
