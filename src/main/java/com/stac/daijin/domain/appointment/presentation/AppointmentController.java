package com.stac.daijin.domain.appointment.presentation;

import com.stac.daijin.domain.appointment.service.SaveAppointmentService;
import com.stac.daijin.domain.appointment.presentation.dto.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/appointment")
public class AppointmentController {
    private final SaveAppointmentService saveAppointmentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void saveAppointment(
            @RequestBody AppointmentRequest request,
            @RequestAttribute String user
    ) {
        saveAppointmentService.execute(request, user);
    }
}
