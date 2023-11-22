package com.stac.daijin.domain.card.facade;

import com.stac.daijin.domain.card.domain.Card;
import com.stac.daijin.domain.card.exception.CardNotFoundException;
import com.stac.daijin.domain.card.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CardFacade {
    private final CardRepository cardRepository;

    @Transactional
    public Card getCardById(
            final UUID id
    ) {
        return cardRepository.findById(id)
                .orElseThrow(() -> CardNotFoundException.EXCEPTION);
    }
}
