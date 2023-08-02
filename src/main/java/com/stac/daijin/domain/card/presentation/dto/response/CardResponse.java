package com.stac.daijin.domain.card.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CardResponse {
    private UUID id;
    private String title;
    private String writer;
    private String content;
    private String image;
}
