package com.hiep.mart.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "administrative_units")
public class AdministrativeUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "full_name_en")
    String fullNameEn;

    @Column(name = "short_name")
    String shortName;

    @Column(name = "short_name_en")
    String shortNameEn;

    @Column(name = "code_name")
    String codeName;

    @Column(name = "code_name_en")
    String codeNameEn;
}
