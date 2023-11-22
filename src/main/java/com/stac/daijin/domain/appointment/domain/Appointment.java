package com.stac.daijin.domain.appointment.domain;

import com.stac.daijin.domain.clinic.domain.Clinic;
import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.global.entity.BaseUUIDEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Appointment extends BaseUUIDEntity {
    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Clinic clinic;

}
