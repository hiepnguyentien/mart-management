package com.hiep.mart.service;

import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.request.AuthenticationRequest;

public interface UserService {
    UserDTO registerUser(AuthenticationRequest request);
}
