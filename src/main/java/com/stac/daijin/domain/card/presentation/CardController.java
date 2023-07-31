package com.stac.daijin.domain.card.presentation;

import com.stac.daijin.domain.card.presentation.dto.SaveCardRequest;
import com.stac.daijin.domain.card.service.DeleteCardService;
import com.stac.daijin.domain.card.service.SaveCardService;
import com.stac.daijin.global.annotation.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final SaveCardService saveCardService;
    private final DeleteCardService deleteCardService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @AuthRequired
    public void saveCard(
            @ModelAttribute SaveCardRequest request,
            @RequestAttribute String user
    ) {
        saveCardService.execute(request, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @AuthRequired
    public void deleteCard(
            @PathVariable UUID id,
            @RequestAttribute String user
    ) {
        deleteCardService.execute(id, user);
    }

}
