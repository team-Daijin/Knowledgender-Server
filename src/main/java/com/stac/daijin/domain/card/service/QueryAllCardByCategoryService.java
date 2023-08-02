package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.CardCategory;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QueryAllCardByCategoryService {

    private final CardRepository cardRepository;

    public List<CardResponse> execute(
            CardCategory category
    ) {
        List<Card> cards = cardRepository.findByCategory(category);
        return cards.
                stream().
                map(
                        card -> new CardResponse(
                                card.getId(),
                                card.getTitle(),
                                card.getUser().getName(),
                                card.getContent(),
                                card.getImage()
                        )
                ).collect(Collectors.toList());
    }

}
