package com.stac.daijin.domain.appointment.service;

import com.stac.daijin.domain.appointment.Appointment;
import com.stac.daijin.domain.appointment.repository.AppointmentRepository;
import com.stac.daijin.domain.clinic.Clinic;
import com.stac.daijin.domain.appointment.presentation.dto.request.AppointmentRequest;
import com.stac.daijin.domain.clinic.repository.ClinicRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAppointmentService {
    private final ClinicRepository clinicRepository;
    private final AppointmentRepository appointmentRepository;
    private final UserFacade userFacade;

    public void execute(
            AppointmentRequest request,
            String accountId
    ) {
        User user = userFacade.findUserByAccountId(accountId);
        Clinic clinic = clinicRepository.findById(request.getClinicId())
                .orElseThrow();
        appointmentRepository.save(
                Appointment.builder()
                        .appointmentDate(request.getDate())
                        .time(request.getTime())
                        .content(request.getContent())
                        .user(user)
                        .clinic(clinic)
                        .build()
        );
    }
}
