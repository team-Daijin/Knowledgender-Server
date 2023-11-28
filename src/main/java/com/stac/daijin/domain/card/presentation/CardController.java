package com.stac.daijin.domain.card.presentation;

import com.stac.daijin.domain.card.presentation.dto.request.SaveCardRequest;
import com.stac.daijin.domain.card.presentation.dto.request.UpdateCardRequest;
import com.stac.daijin.domain.card.presentation.dto.response.CardListResponse;
import com.stac.daijin.domain.card.presentation.dto.response.CardResponse;
import com.stac.daijin.domain.card.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final SaveCardService saveCardService;
    private final DeleteCardService deleteCardService;
    private final UpdateCardService updateCardService;
    private final QueryCategoryCardListService queryCategoryCardListService;
    private final QueryUserCardService queryUserCardService;
    private final QueryCardByIdService queryCardByIdService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCard(
            @ModelAttribute @Valid SaveCardRequest request
    ) {
        saveCardService.execute(request);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public CardListResponse getCardByCategory(
            @RequestParam String category
    ) {
        return queryCategoryCardListService.execute(category);
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public CardListResponse getCardByUser() {
        return queryUserCardService.execute();
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
    public void updateCard(
            @PathVariable UUID id,
            @ModelAttribute UpdateCardRequest request
    ) {
        updateCardService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(
            @PathVariable UUID id
    ) {
        deleteCardService.execute(id);
    }
}
