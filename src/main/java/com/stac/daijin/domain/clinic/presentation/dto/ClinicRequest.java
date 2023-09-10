package com.stac.daijin.domain.clinic.presentation.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClinicRequest {

    private String name;

    private MultipartFile image;

    private String introduce;

    private String contact;

    private String code;

    private String address;

    private Double latitude;

    private Double longitude;
}
