package com.stac.daijin.domain.card;

import com.stac.daijin.domain.card.enums.CardCategory;
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

    private String category;

    private String content;

    private String image;

    @Setter
    @ManyToOne(optional = false)
    private User user;

    public void updateCard(String title, String category, String content, String image) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.image = image;
    }
}
