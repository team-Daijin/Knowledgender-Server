package com.stac.daijin.domain.banner.domain;

import com.stac.daijin.domain.banner.domain.type.State;
import com.stac.daijin.global.entity.BaseUUIDEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
