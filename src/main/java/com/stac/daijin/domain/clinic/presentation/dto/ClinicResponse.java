package com.stac.daijin.domain.clinic.presentation.dto;

import com.stac.daijin.domain.clinic.Clinic;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClinicResponse {
    private String name;
    private String address;
    private String contact;
    private String introduce;
    private String image;
    private Boolean appointmentAvailable;

    public static ClinicResponse of(Clinic clinic) {
        return new ClinicResponse(
                clinic.getName(),
                clinic.getCoordinate().getAddress(),
                clinic.getContact(),
                clinic.getIntroduce(),
                clinic.getImage(),
                clinic.getAppointmentAvailable()
        );
    }

}
