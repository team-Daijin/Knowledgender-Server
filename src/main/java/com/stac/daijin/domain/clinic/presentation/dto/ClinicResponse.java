package com.stac.daijin.domain.clinic.presentation.dto;

import com.stac.daijin.domain.clinic.domain.Clinic;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ClinicResponse {
    private UUID id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String contact;
    private String introduce;
    private String image;
    private Boolean appointmentAvailable;

    public static ClinicResponse of(Clinic clinic) {
        return new ClinicResponse(
                clinic.getId(),
                clinic.getName(),
                clinic.getCoordinate().getAddress(),
                clinic.getCoordinate().getLatitude(),
                clinic.getCoordinate().getLongitude(),
                clinic.getContact(),
                clinic.getIntroduce(),
                clinic.getImage(),
                clinic.getAppointmentAvailable()
        );
    }

}
