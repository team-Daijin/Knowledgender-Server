package com.stac.daijin.domain.card.presentation;

import com.stac.daijin.domain.card.enums.CardCategory;
import com.stac.daijin.domain.card.presentation.dto.request.SaveCardRequest;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.service.*;
import com.stac.daijin.global.annotation.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final SaveCardService saveCardService;
    private final DeleteCardService deleteCardService;
    private final UpdateCardService updateCardService;
    private final QueryAllCardByCategoryService queryAllCardByCategoryService;
    private final QueryCardByIdService queryCardByIdService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @AuthRequired
    public void saveCard(
            @ModelAttribute @Valid SaveCardRequest request,
            @RequestAttribute String user
    ) {
        saveCardService.execute(request, user);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CardResponse> getCardByCategory(
            @RequestParam("category") CardCategory category
    ) {
        return queryAllCardByCategoryService.execute(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardResponse getCardById(
            @PathVariable UUID id
    ) {
        return queryCardByIdService.execute(id);
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
