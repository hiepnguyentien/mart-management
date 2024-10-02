package com.hiep.mart.domain.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class RegisterRequest {
    private CustomerRequest customerRequest;
    private AuthenticationRequest authenticationRequest;
}

