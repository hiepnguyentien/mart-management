package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class CustomerDTO {
    Long customerId;
    String firstName;
    String lastName;
    String address;
    String email;
    String phoneNumber;
    String gender;
    LocalDate dateOfBirth;
    Double accumulatedPoints;
    String customerStatus;
}
