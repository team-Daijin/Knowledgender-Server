package com.stac.daijin.domain.clinic.presentation;

import com.stac.daijin.domain.clinic.presentation.dto.ClinicResponse;
import com.stac.daijin.domain.clinic.presentation.dto.ClinicRequest;
import com.stac.daijin.domain.clinic.service.QueryClinicService;
import com.stac.daijin.domain.clinic.service.RegisterClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clinic")
public class ClinicController {

    private final RegisterClinicService registerClinicService;
    private final QueryClinicService queryClinicService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerClinic(
            @RequestBody ClinicRequest request
    ) {
        registerClinicService.execute(request);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ClinicResponse> getClinicListByLocation(
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude
    ) {
        return queryClinicService.execute(latitude, longitude);
    }

}
