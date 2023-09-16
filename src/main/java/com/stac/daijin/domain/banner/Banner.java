package com.stac.daijin.domain.banner;

import com.stac.daijin.domain.banner.enums.State;
import com.stac.daijin.global.jpa.BaseUUIDEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner extends BaseUUIDEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String fileUrl;

    @Column(nullable = true)
    private String redirect;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private State state;
}
