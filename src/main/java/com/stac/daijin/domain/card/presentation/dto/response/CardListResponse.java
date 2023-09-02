package com.stac.daijin.domain.card.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CardListResponse {
    private List<CardResponse> cardResponseList;
}
