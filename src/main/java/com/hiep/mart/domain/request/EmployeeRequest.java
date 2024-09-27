package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class EmployeeRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String firstName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String lastName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String username;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String password;
    String address;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String email;
    String phoneNumber;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String gender;
    LocalDate dateOfBirth;
    String role;
}
