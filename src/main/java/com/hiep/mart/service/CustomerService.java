package com.hiep.mart.service;

import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.request.CustomerRequest;

import java.util.Locale;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerRequest request);
    CustomerDTO viewProfile(Locale locale);
    CustomerDTO updateProfile(CustomerRequest request, Locale locale);
    void changePassword(String currentPassword, String newPassword);
    void forgotPassword();
    void resetPassword();
}
