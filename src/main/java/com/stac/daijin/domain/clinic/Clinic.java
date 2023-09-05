package com.stac.daijin.domain.clinic;

import com.stac.daijin.domain.appointment.Appointment;
import com.stac.daijin.global.jpa.BaseUUIDEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Clinic extends BaseUUIDEntity {
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
