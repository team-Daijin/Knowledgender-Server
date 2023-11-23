package com.stac.daijin.domain.clinic.service;

import com.stac.daijin.domain.clinic.domain.Coordinate;
import com.stac.daijin.domain.clinic.presentation.dto.ClinicResponse;
import com.stac.daijin.domain.clinic.domain.repository.ClinicRepository;
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
        return clinicRepository.findAllByCoordinateAndDistanceInMeters(
                Coordinate.of(latitude, longitude), 10000
        ).stream().map(
                ClinicResponse::of
        ).collect(Collectors.toList());
    }


}
