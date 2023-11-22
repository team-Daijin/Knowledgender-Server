package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.domain.Card;
import com.stac.daijin.domain.card.facade.CardFacade;
import com.stac.daijin.domain.card.domain.repository.CardRepository;
import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.domain.user.exception.IsNotWriterException;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCardService {

    private final CardFacade cardFacade;
    private final CardRepository cardRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(
            final UUID id
    ) {
        User user = userFacade.getCurrentUser();
        Card card = cardFacade.getCardById(id);

        if (!user.equals(card.getUser())) {
            throw IsNotWriterException.EXCEPTION;
        }
        cardRepository.deleteById(card.getId());
    }
}
