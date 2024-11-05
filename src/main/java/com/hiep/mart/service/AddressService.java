package com.hiep.mart.service;

import com.hiep.mart.domain.dto.DistrictDTO;
import com.hiep.mart.domain.dto.ProvinceDTO;
import com.hiep.mart.domain.dto.WardDTO;

import java.util.List;

public interface AddressService {
    List<DistrictDTO> getDistrictByProvinceCode(String provinceCode);
    List<WardDTO> getWardByDistrictCode(String provinceCode);
    List<ProvinceDTO> getAllProvince();
}
