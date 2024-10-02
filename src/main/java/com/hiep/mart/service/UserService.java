package com.hiep.mart.service;

import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.request.AuthenticationRequest;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.domain.request.RegisterRequest;

import java.util.Locale;

public interface UserService {
    UserDTO registerUser(RegisterRequest registerRequest, Locale locale);
}
