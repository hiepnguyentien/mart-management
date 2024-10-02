package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.request.CustomerRequest;
import com.hiep.mart.domain.response.ApiResponse;
import com.hiep.mart.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService customerService;

    @PostMapping
    ApiResponse<CustomerDTO> addCustomer(@RequestBody CustomerRequest request) {
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.createCustomer(request));
        return apiResponse;
    }
}
