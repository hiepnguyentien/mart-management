package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.ShiftDTO;
import com.hiep.mart.domain.entity.Shift;
import com.hiep.mart.domain.request.ShiftRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShiftMapper {
    Shift toShift(ShiftRequest shiftRequest);
    ShiftDTO toShiftDTO(Shift shift);
    void updateShift(@MappingTarget Shift shift, ShiftRequest shiftRequest);
}
