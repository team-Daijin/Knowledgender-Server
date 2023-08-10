package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.presentation.dto.request.SaveCardRequest;
import com.stac.daijin.domain.card.repository.CardRepository;
import com.stac.daijin.domain.user.Role;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserPermissionException;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveCardService {

    private final CardRepository cardRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(
            SaveCardRequest request,
            String accountId
    ) {
        User user = userFacade.getUserByAccountId(accountId);

        if (!user.getRole().equals(Role.EXPORT)) {
            throw UserPermissionException.EXCEPTION;
        }

        Card card = Card.builder()
                .title(request.getTitle())
                .category(request.getCategory())
                .content(request.getContent())
                //.image(request.getImage())
                .image("")
                .build();
        card.setUser(user);
        cardRepository.save(card);
    }

}
