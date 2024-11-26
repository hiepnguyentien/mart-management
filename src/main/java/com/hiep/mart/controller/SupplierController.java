package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.SupplierDTO;
import com.hiep.mart.domain.request.SupplierRequest;
import com.hiep.mart.service.SupplierService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "supplier")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierController {
    SupplierService supplierService;

    @GetMapping
    public List<SupplierDTO> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/find-by-name/{name}")
    public List<SupplierDTO> getSupplier(@PathVariable String name) {
        return supplierService.getSuppliersByName(name);
    }

    @GetMapping("/find-by-id/{id}")
    public SupplierDTO getSupplier(@PathVariable Long id,
                                   @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return supplierService.getSupplierById(id, locale);
    }

    @PostMapping
    public SupplierDTO create(@RequestBody SupplierRequest request) {
        return supplierService.addSupplier(request);
    }

    @PutMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id,
                               @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        supplierService.deleteSupplier(id, locale);
    }
}
