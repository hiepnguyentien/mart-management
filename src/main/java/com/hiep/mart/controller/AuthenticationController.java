package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.IntrospectResponse;
import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.request.AuthenticationRequest;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.domain.request.IntrospectRequest;
import com.hiep.mart.domain.request.RegisterRequest;
import com.hiep.mart.domain.response.ApiResponse;
import com.hiep.mart.domain.response.AuthenticationResponse;
import com.hiep.mart.service.UserService;
import com.hiep.mart.service.impl.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Locale;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    UserService userService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> logIn(@RequestBody AuthenticationRequest authenticationRequest, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        var result = authenticationService.authenticate(authenticationRequest, locale);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> logOut(@RequestBody IntrospectRequest introspectRequest)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/register")
    ApiResponse<UserDTO> register(@Valid @RequestBody RegisterRequest registerRequest, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<UserDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.registerUser(registerRequest, locale));
        return apiResponse;
    }
}
