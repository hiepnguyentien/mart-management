package com.hiep.mart.domain.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "shift")
public class Shift {
    @Id
    @SequenceGenerator(name = "shift_sequence", sequenceName = "shift_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_sequence")
    @Column(name = "shift_id")
    Long shiftId;
    @Column(name = "shift_name")
    String shiftName;
    @Column(name = "shift_date")
    String shiftDate;
    @Column(name = "shift_start_time")
    DayOfWeek shiftStartTime;
    @Column(name = "shift_end_time")
    LocalTime shiftEndTime;
    @Column(name = "shift_status")
    String shiftStatus;
}
