package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.DistrictDTO;
import com.hiep.mart.domain.dto.ProvinceDTO;
import com.hiep.mart.domain.dto.WardDTO;
import com.hiep.mart.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressController {
    AddressService addressService;

    @GetMapping("/district/{provinceCode}")
    public List<DistrictDTO> findByProvinceCode(@PathVariable("provinceCode") String provinceCode) {
        return addressService.getDistrictByProvinceCode(provinceCode);
    }

    @GetMapping("/ward/{districtCode}")
    public List<WardDTO> findByDistrictCode(@PathVariable("districtCode") String districtCode) {
        return addressService.getWardByDistrictCode(districtCode);
    }

    @GetMapping("/province")
    public List<ProvinceDTO> findAllProvinces() {
        return addressService.getAllProvince();
    }
}
