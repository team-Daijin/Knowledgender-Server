package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.facade.CardFacade;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.IsNotWriterException;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.thirdparty.s3.UploadS3Service;
import com.stac.daijin.thirdparty.s3.enums.Directory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCardService {

    private final CardFacade cardFacade;
    private final UserFacade userFacade;
    private final UploadS3Service uploadS3Service;

    @Transactional
    public void execute(
            final UUID id,
            final UpdateCardRequest request,
            final String accountId
    ) {
        Card card = cardFacade.getCardById(id);
        User user = userFacade.findUserByAccountId(accountId);
        if (user.equals(card.getUser())) {
            throw IsNotWriterException.EXCEPTION;
        }
        card.updateCard(
                request.getTitle(),
                request.getCategory(),
                request.getContent(),
                uploadS3Service.uploadImage(request.getImage(), Directory.CARD)
        );
    }
}
