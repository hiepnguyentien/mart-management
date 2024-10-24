package com.hiep.mart.service.impl;

import com.hiep.mart.domain.constant.PredefinedRole;
import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.entity.Customers;
import com.hiep.mart.domain.entity.Role;
import com.hiep.mart.domain.entity.Users;
import com.hiep.mart.domain.mapper.UserMapper;
import com.hiep.mart.domain.request.AuthenticationRequest;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.domain.request.RegisterRequest;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.CustomerRepository;
import com.hiep.mart.repository.RoleRepository;
import com.hiep.mart.repository.UserRepository;
import com.hiep.mart.service.CustomerService;
import com.hiep.mart.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    CustomerService customerService;
    CustomerRepository customerRepository;
    MessageSource messageSource;
    RoleRepository roleRepository;

    @Transactional
    @Override
    public UserDTO registerUser(RegisterRequest registerRequest, Locale locale) throws AppException {
        CustomerDTO customerDTO = customerService.createCustomer(registerRequest.getCustomerRequest());
        if (registerRequest.getAuthenticationRequest().getPassword() == null || registerRequest.getAuthenticationRequest().getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        Customers customers = customerRepository.findById(customerDTO.getCustomerId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));

        Role customerRole = roleRepository.save(Role.builder()
                .name(PredefinedRole.CUSTOMER_ROLE)
                .description("Customer role")
                .build());

        var roles = new HashSet<Role>();
        roles.add(customerRole);

        var user = Users.builder()
                .customers(customers)
                .username(registerRequest.getAuthenticationRequest().getUsername())
                .password(passwordEncoder.encode(registerRequest.getAuthenticationRequest().getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal " + principal);
        if (principal instanceof Users) {
            UserDTO userDetails = (UserDTO) principal;
            return userDetails.getUserId();
        }
        throw new IllegalStateException("User is not authenticated");
    }
}
