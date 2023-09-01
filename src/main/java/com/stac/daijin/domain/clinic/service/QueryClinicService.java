package com.stac.daijin.domain.clinic.service;

import com.stac.daijin.domain.clinic.Coordinate;
import com.stac.daijin.domain.clinic.Clinic;
import com.stac.daijin.domain.clinic.presentation.dto.ClinicResponse;
import com.stac.daijin.domain.clinic.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryClinicService {
    private final ClinicRepository clinicRepository;

    public List<ClinicResponse> execute(
            double latitude,
            double longitude
    ) {

        List<Clinic> clinics = clinicRepository.findAllByCoordinateAndDistanceInMeters(
                Coordinate.of(latitude, longitude),
                3000
        );

        return clinics.stream().map(
                clinic -> new ClinicResponse(
                        clinic.getName(), clinic.getCoordinate().getAddress(), clinic.getContact(), clinic.getIntroduce(), clinic.getAppointmentAvailable()
                )
        ).collect(Collectors.toList());

    }


}
