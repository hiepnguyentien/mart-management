package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.DistrictDTO;
import com.hiep.mart.domain.dto.WardDTO;
import com.hiep.mart.domain.entity.District;
import com.hiep.mart.domain.entity.Ward;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WardMapper {
    @Mapping(source = "districtCode", target = "district.code")
    Ward toWard(WardDTO dto);
    @Mapping(source = "district.code", target = "districtCode")
    WardDTO toWardDTO(Ward ward);
}