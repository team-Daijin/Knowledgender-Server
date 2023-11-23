package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.presentation.dto.response.CardListResponse;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
