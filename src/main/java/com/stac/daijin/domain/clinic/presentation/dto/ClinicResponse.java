package com.stac.daijin.domain.clinic.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClinicResponse {
    private String name;
    private String address;
    private String contact;
    private String introduce;
    private Boolean appointmentAvailable;

}
