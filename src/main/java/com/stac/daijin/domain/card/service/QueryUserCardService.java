package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.domain.repository.CardRepository;
import com.stac.daijin.domain.card.presentation.dto.response.CardListResponse;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryUserCardService {
    private final CardRepository cardRepository;
    private final UserFacade userFacade;

    public CardListResponse execute() {
        return new CardListResponse(
                cardRepository.findAllByUser(userFacade.getCurrentUser())
                        .stream()
                        .map(CardResponse::of)
                        .collect(Collectors.toList())
        );
    }
}
