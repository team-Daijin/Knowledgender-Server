package com.stac.daijin.domain.appointment;

import com.stac.daijin.domain.clinic.Clinic;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.global.jpa.BaseUUIDEntity;
import lombok.*;
import org.springframework.context.annotation.Bean;

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
