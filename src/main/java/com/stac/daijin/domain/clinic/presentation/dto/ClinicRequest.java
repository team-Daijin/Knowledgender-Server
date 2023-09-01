package com.stac.daijin.domain.clinic.presentation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClinicRequest {

    private String name;

    private String introduce;

    private String contact;

    private String code;

    private LocationRequest location;

    public String getAddress() {
        return location.getAddress();
    }

    public Double getLatitude() {
        return location.getLatitude();
    }

    public Double getLongitude() {
        return location.getLongitude();
    }

    @Getter
    static private class LocationRequest {
        private String address;
        private Double latitude;
        private Double longitude;
    }


}
