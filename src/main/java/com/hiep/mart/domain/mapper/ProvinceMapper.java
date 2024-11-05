package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.ProvinceDTO;
import com.hiep.mart.domain.entity.Province;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {
    Province toProvince(ProvinceDTO provinceDTO);
    ProvinceDTO toProvinceDTO(Province province);
}
