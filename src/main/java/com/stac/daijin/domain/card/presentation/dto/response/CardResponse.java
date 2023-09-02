package com.stac.daijin.domain.card.presentation.dto.response;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.enums.CardCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CardResponse {
    private UUID id;
    private String title;
    private String writer;
    private String category;
    private String content;
    private String image;

    public static CardResponse of(Card card) {
        return CardResponse.builder()
                .id(card.getId())
                .title(card.getTitle())
                .writer(card.getUser().getAccountId())
                .category(card.getCategory())
                .content(card.getContent())
                .image(card.getImage())
                .build();
    }
}
