package com.hiep.mart.domain.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
