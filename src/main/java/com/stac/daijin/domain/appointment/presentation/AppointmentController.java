package com.stac.daijin.domain.appointment.presentation;

import com.stac.daijin.domain.appointment.presentation.dto.response.AppointmentListResponse;
import com.stac.daijin.domain.appointment.service.QueryUserAppointmentListService;
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
    private final QueryUserAppointmentListService queryUserAppointmentListService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void saveAppointment(
            @RequestBody AppointmentRequest request
    ) {
        saveAppointmentService.execute(request);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentListResponse getAppointmentByUser() {
        return queryUserAppointmentListService.execute();
    }
}
