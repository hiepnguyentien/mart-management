package com.hiep.mart.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ShiftDTO {
    Long shiftId;
    String shiftName;
    String shiftDate;
    DayOfWeek shiftStartTime;
    LocalTime shiftEndTime;
    String shiftStatus;
}
