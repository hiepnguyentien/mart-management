package com.hiep.mart.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ApiResponse <T> {
    int code = 1000;
    String message;
    T result;
}
