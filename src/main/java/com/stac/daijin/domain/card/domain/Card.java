package com.stac.daijin.domain.card.domain;

import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.global.entity.BaseUUIDEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Card extends BaseUUIDEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String thumbnail;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String image;

    @CreationTimestamp
    private LocalDateTime createAt;

    @Setter
    @ManyToOne(optional = false)
    private User user;

    public void updateCard(String title, String category, String content, String image, String thumbnail) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.image = image;
        this.thumbnail = thumbnail;
    }
}
