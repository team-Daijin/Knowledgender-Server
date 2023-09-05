package com.stac.daijin.domain.card.service;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.presentation.dto.request.SaveCardRequest;
import com.stac.daijin.domain.card.repository.CardRepository;
import com.stac.daijin.domain.user.enums.Role;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserPermissionException;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.thirdparty.s3.UploadS3Service;
import com.stac.daijin.thirdparty.s3.enums.Directory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveCardService {

    private final CardRepository cardRepository;
    private final UserFacade userFacade;
    private final UploadS3Service uploadS3Service;

    @Transactional
    public void execute(
            final SaveCardRequest request
    ) {
        User user = userFacade.getCurrentUser();

        if (!user.getRole().equals(Role.EXPORT)) {
            throw UserPermissionException.EXCEPTION;
        }

        Card card = Card.builder()
                .title(request.getTitle())
                .category(request.getCategory())
                .content(request.getContent())
                .image(uploadS3Service.uploadImage(request.getImage(), Directory.CARD))
                .build();
        card.setUser(user);
        cardRepository.save(card);
    }

}
