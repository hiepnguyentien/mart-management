package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.SupplierDTO;
import com.hiep.mart.domain.request.SupplierRequest;
import com.hiep.mart.service.SupplierService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "supplier")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierController {
    SupplierService supplierService;

    @PostMapping
    public SupplierDTO create(@RequestBody SupplierRequest request) {
        return supplierService.createSupplier(request);
    }
}
