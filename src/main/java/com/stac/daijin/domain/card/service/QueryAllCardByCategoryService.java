package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.enums.CardCategory;
import com.stac.daijin.domain.card.facade.CardFacade;
import com.stac.daijin.domain.card.presentation.dto.response.CardListResponse;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllCardByCategoryService {

    private final CardRepository cardRepository;

    @Transactional(readOnly = true)
    public CardListResponse execute(
            final String category
    ) {
        return new CardListResponse(
                cardRepository.findAllByCategory(category, Sort.by(Sort.Direction.DESC, "createAt"))
                        .stream()
                        .map(CardResponse::of)
                        .collect(Collectors.toList())
        );
    }

}
