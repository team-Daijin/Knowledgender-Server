package com.stac.daijin.domain.card;

import com.stac.daijin.domain.user.User;
import com.stac.daijin.global.jpa.BaseUUIDEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Card extends BaseUUIDEntity {
    private String title;

    @Enumerated(EnumType.STRING)
    private CardCategory category;

    private String content;

    private String image;

    @Setter
    @ManyToOne(optional = false)
    private User user;

}
