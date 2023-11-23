package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.domain.Card;
import com.stac.daijin.domain.card.facade.CardFacade;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.domain.user.exception.IsNotWriterException;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.thirdparty.s3.service.UploadS3Service;
import com.stac.daijin.thirdparty.s3.type.Directory;
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
            final UpdateCardRequest request
    ) {
        Card card = cardFacade.getCardById(id);
        User user = userFacade.getCurrentUser();
        if (user.equals(card.getUser())) {
            throw IsNotWriterException.EXCEPTION;
        }
        card.updateCard(
                request.getTitle(),
                request.getCategory(),
                request.getContent(),
                uploadS3Service.uploadImage(request.getImage(), Directory.CARD),
                uploadS3Service.uploadImage(request.getThumbnail(), Directory.CARD)
        );
    }
}
