package com.hiep.mart.domain.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
