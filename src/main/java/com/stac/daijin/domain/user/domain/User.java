package com.stac.daijin.domain.user.domain;

import com.stac.daijin.domain.appointment.domain.Appointment;
import com.stac.daijin.domain.card.domain.Card;
import com.stac.daijin.domain.user.domain.type.Gender;
import com.stac.daijin.domain.user.domain.type.Job;
import com.stac.daijin.domain.user.domain.type.Role;
import com.stac.daijin.global.entity.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class User extends BaseUUIDEntity {
    @Column(unique = true, nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Job job;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj) || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return getAccountId() != null && Objects.equals(getAccountId(), user.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId());
    }
}
