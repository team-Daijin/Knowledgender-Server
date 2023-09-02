package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.enums.CardCategory;
import com.stac.daijin.domain.card.facade.CardFacade;
import com.stac.daijin.domain.card.presentation.dto.response.CardListResponse;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QueryAllCardByCategoryService {

    private final CardRepository cardRepository;

    @Transactional(readOnly = true)
    public CardListResponse execute(
            final String category
    ) {
        return new CardListResponse(
                cardRepository.findByCategory(category)
                        .stream()
                        .map(CardResponse::of)
                        .collect(Collectors.toList())
        );
    }

}
