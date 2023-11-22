package com.stac.daijin.domain.clinic.domain;

import com.stac.daijin.domain.appointment.domain.Appointment;
import com.stac.daijin.global.entity.BaseUUIDEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Clinic extends BaseUUIDEntity {
    private UUID id;
    private String name;

    private String introduce;

    private String contact;

    private Coordinate coordinate;

    private String code;

    @Column(length = 500)
    private String image;

    private Boolean appointmentAvailable;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private Set<Appointment> appointment;

}
