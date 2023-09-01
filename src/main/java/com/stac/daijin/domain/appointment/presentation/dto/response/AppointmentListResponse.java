package com.stac.daijin.domain.appointment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AppointmentListResponse {
    private List<AppointmentResponse> appointmentResponses;
}
