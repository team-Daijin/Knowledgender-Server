package com.stac.daijin.domain.appointment.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppointmentRequest {
    private LocalDate date;
    private String time;
    private String content;
    private UUID clinicId;
}
