package com.stac.daijin.domain.appointment.presentation.dto.response;

import com.stac.daijin.domain.appointment.domain.Appointment;
import com.stac.daijin.domain.clinic.domain.Clinic;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AppointmentResponse {
    private String name;
    private String introduce;
    private String contact;
    private String code;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private LocationResponse location;

    @Getter
    @Builder
    private static class LocationResponse {
        private String address;
        private Double latitude;
        private Double longitude;
    }

    public static AppointmentResponse of(
            Clinic clinic, Appointment appointment
    ) {
        return AppointmentResponse.builder()
                .name(clinic.getName())
                .introduce(clinic.getIntroduce())
                .contact(clinic.getContact())
                .code(clinic.getCode())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getTime())
                .location(
                        LocationResponse.builder()
                                .address(clinic.getCoordinate().getAddress())
                                .latitude(clinic.getCoordinate().getLatitude())
                                .longitude(clinic.getCoordinate().getLongitude())
                                .build()
                ).build();
    }
}
