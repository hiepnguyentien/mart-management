package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.domain.response.ApiResponse;
import com.hiep.mart.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService customerService;

    @GetMapping("/info")
    public ApiResponse<CustomerDTO> info(@RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.viewProfile(locale));
        return apiResponse;
    }

    @PostMapping
    ApiResponse<CustomerDTO> addCustomer(@RequestBody CustomerRequest request) {
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.createCustomer(request));
        return apiResponse;
    }

    @PutMapping
    ApiResponse<CustomerDTO> updateCustomer(@RequestBody CustomerRequest request,
                                            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.updateProfile(request, locale));
        return apiResponse;
    }
}
