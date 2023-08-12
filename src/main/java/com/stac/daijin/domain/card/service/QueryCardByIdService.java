package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.exception.CardNotFoundException;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QueryCardByIdService {

    private final CardRepository cardRepository;

    @Transactional(readOnly = true)
    public CardResponse execute(
            final UUID id
    ) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> CardNotFoundException.EXCEPTION);
        return new CardResponse(
                card.getId(),
                card.getTitle(),
                card.getUser().getName(),
                card.getCategory(),
                card.getContent(),
                card.getImage()
        );
    }

}
