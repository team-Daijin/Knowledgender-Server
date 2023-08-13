package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.enums.CardCategory;
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
    public List<CardResponse> execute(
            final String category
    ) {
        List<Card> cards = cardRepository.findByCategory(category);
        return cards.
                stream().
                map(
                        card -> new CardResponse(
                                card.getId(),
                                card.getTitle(),
                                card.getUser().getName(),
                                card.getCategory(),
                                card.getContent(),
                                card.getImage()
                        )
                ).collect(Collectors.toList());
    }

}
