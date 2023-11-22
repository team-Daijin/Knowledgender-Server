package com.stac.daijin.domain.appointment.domain.repository;

import com.stac.daijin.domain.appointment.domain.Appointment;
import com.stac.daijin.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByUser(User user);
}
