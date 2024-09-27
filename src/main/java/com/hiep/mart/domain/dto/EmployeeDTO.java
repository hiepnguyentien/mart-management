package com.hiep.mart.domain.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class EmployeeDTO {
    Long employeeId;
    String firstName;
    String lastName;
    String username;
    String password;
    String address;
    String email;
    String phoneNumber;
    String gender;
    LocalDate dateOfBirth;
    String role;
}
