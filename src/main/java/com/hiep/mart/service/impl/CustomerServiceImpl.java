package com.hiep.mart.service.impl;

import com.hiep.mart.domain.entity.Users;
import com.hiep.mart.domain.enumeration.CustomerStatus;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.entity.Customers;
import com.hiep.mart.domain.mapper.CustomerMapper;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.repository.CustomerRepository;
import com.hiep.mart.service.CustomerService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;
    UserRepository userRepository;
    MessageSource messageSource;
    PasswordEncoder passwordEncoder;

    @Override
    public CustomerDTO createCustomer(CustomerRequest request) {
        Customers customers = customerMapper.toCustomer(request);
        customers.setCustomerStatus(CustomerStatus.AVAILABLE);
        customerRepository.save(customers);
        return customerMapper.toCustomerDTO(customers);
    }

    @Override
//    @PostAuthorize("returnObject.username == authentication.name")
    public CustomerDTO viewProfile(Locale locale) {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Users user = userRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));

        Customers customer = customerRepository.findById(user.getCustomers().getCustomerId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
//    @PostAuthorize("returnObject.username == authentication.name")
    public CustomerDTO updateProfile(CustomerRequest request, Locale locale) {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Users user = userRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));

        Customers customer = customerRepository.findById(user.getCustomers().getCustomerId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));

        customerMapper.updateCustomer(customer, request);
        customerRepository.save(customer);
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public void changePassword(String currentPassword, String newPassword) {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Users user = userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void forgotPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forgotPassword'");
    }

    @Override
    public void resetPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetPassword'");
    }
}
