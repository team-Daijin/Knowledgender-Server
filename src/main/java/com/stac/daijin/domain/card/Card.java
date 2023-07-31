package com.stac.daijin.domain.card;

import com.stac.daijin.domain.user.User;
import com.stac.daijin.global.jpa.BaseUUIDEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Card extends BaseUUIDEntity {
    @Id
    private UUID id;

    private String title;

    @Enumerated(EnumType.STRING)
    private CardCategory category;

    private String content;

    private String image;

    @Setter
    @ManyToOne(optional = false)
    private User user;

}
