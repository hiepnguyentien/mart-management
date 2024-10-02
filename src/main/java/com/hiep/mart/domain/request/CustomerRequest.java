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
public class CustomerRequest {
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String firstName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String lastName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String address;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String email;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String phoneNumber;
    String gender;
    LocalDate dateOfBirth;
}
