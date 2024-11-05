package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.DistrictDTO;
import com.hiep.mart.domain.entity.District;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DistrictMapper {
    @Mapping(source = "provinceCode", target = "province.code")
    District toDistrict(DistrictDTO dto);
    @Mapping(source = "province.code", target = "provinceCode")
    DistrictDTO toDistrictDTO(District district);
}
