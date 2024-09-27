package com.hiep.mart.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ShiftRequest {
    String shiftName;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    String shiftDate;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    DayOfWeek shiftStartTime;
    @NotNull(message = "REQUIRED_FIELD_MISSING")
    LocalTime shiftEndTime;
    String shiftStatus;
}
