package com.stac.daijin.domain.clinic.service;

import com.stac.daijin.domain.clinic.Coordinate;
import com.stac.daijin.domain.clinic.Clinic;
import com.stac.daijin.domain.clinic.presentation.dto.ClinicRequest;
import com.stac.daijin.domain.clinic.repository.ClinicRepository;
import com.stac.daijin.thirdparty.s3.UploadS3Service;
import com.stac.daijin.thirdparty.s3.enums.Directory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterClinicService {
    private final ClinicRepository clinicRepository;
    private final UploadS3Service uploadS3Service;

    public void execute(
            final ClinicRequest request
    ) {
        clinicRepository.save(
                Clinic.builder()
                        .name(request.getName())
                        .introduce(request.getIntroduce())
                        .contact(request.getContact())
                        .image(uploadS3Service.uploadImage(
                                request.getImage(), Directory.CLINIC
                        ))
                        .coordinate(
                                Coordinate.of(
                                        request.getLatitude(),
                                        request.getLongitude(),
                                        request.getAddress()
                                )
                        )
                        .appointmentAvailable(true)
                        .code(request.getCode())
                        .build()
        );
    }

}
