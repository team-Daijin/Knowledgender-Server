package com.stac.daijin.domain.card.presentation;

import com.stac.daijin.domain.card.CardCategory;
import com.stac.daijin.domain.card.presentation.dto.request.SaveCardRequest;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.card.service.DeleteCardService;
import com.stac.daijin.domain.card.service.QueryAllCardByCategoryService;
import com.stac.daijin.domain.card.service.SaveCardService;
import com.stac.daijin.domain.card.service.UpdateCardService;
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
    private final UpdateCardService updateCardService;
    private final QueryAllCardByCategoryService queryAllCardByCategoryService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @AuthRequired
    public void saveCard(
            @ModelAttribute SaveCardRequest request,
            @RequestAttribute String user
    ) {
        saveCardService.execute(request, user);
    }

    @GetMapping("/{category}")
    @ResponseStatus(HttpStatus.OK)
    public void getCardByCategory(
            @PathVariable CardCategory category
    ) {
        queryAllCardByCategoryService.execute(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getCardById(
            @PathVariable UUID id
    ) {

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @AuthRequired
    public void updateCard(
            @PathVariable UUID id,
            @ModelAttribute UpdateCardRequest request,
            @RequestAttribute String user
    ) {
        updateCardService.execute(id, request, user);
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
