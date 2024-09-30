package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.entity.Users;
import com.hiep.mart.domain.mapper.UserMapper;
import com.hiep.mart.domain.request.AuthenticationRequest;
import com.hiep.mart.repository.UserRepository;
import com.hiep.mart.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    @Override
    public UserDTO registerUser(AuthenticationRequest request) {
        var user = Users.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }
}
