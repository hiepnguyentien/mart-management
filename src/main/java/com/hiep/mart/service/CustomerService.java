package com.hiep.mart.service;

public interface CustomerService {
    void register();
    void login();
    void logout();
    void viewProfile();
    void updateProfile();
    void changePassword();
    void forgotPassword();
    void resetPassword();
}
