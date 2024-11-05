package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.DistrictDTO;
import com.hiep.mart.domain.dto.ProvinceDTO;
import com.hiep.mart.domain.dto.WardDTO;
import com.hiep.mart.domain.mapper.DistrictMapper;
import com.hiep.mart.domain.mapper.ProvinceMapper;
import com.hiep.mart.domain.mapper.WardMapper;
import com.hiep.mart.repository.DistrictRepository;
import com.hiep.mart.repository.ProvinceRepositoy;
import com.hiep.mart.repository.WardRepository;
import com.hiep.mart.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressServiceImpl implements AddressService {

    ProvinceRepositoy provinceRepositoy;
    DistrictRepository districtRepository;
    WardRepository wardRepository;
    DistrictMapper districtMapper;
    WardMapper wardMapper;
    ProvinceMapper provinceMapper;

    @Override
    public List<DistrictDTO> getDistrictByProvinceCode(String provinceCode) {
        return districtRepository.findDistrictByProvinceCode(provinceCode)
                .stream().map(districtMapper::toDistrictDTO).collect(Collectors.toList());
    }

    @Override
    public List<WardDTO> getWardByDistrictCode(String provinceCode) {
        return wardRepository.findWardByDistrictCode(provinceCode)
                .stream().map(wardMapper::toWardDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProvinceDTO> getAllProvince() {
        return provinceRepositoy.findAll()
                .stream().map(provinceMapper::toProvinceDTO).collect(Collectors.toList());
    }
}
