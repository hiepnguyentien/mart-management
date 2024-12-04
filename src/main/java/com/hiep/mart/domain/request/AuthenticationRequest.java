package com.hiep.mart.domain.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
//    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String username;
//    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String password;
}
