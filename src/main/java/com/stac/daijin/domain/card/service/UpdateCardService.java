package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.exception.CardNotFoundException;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.card.repository.CardRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.IsNotWriterException;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCardService {

    private final CardRepository cardRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(
            UUID id,
            UpdateCardRequest request,
            String accountId
    ) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> CardNotFoundException.EXCEPTION);
        User user = userFacade.getUserByAccountId(accountId);
        if (user.equals(card.getUser())) {
            throw IsNotWriterException.EXCEPTION;
        }
        card.updateCard(
                request.getTitle(),
                request.getCategory(),
                request.getContent(),
                ""
        );
    }
}
