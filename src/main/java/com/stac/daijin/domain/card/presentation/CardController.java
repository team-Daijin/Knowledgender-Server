package com.stac.daijin.domain.card.presentation;

import com.stac.daijin.domain.card.presentation.dto.SaveCardRequest;
import com.stac.daijin.domain.card.service.SaveCardService;
import com.stac.daijin.global.annotation.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final SaveCardService saveCardService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @AuthRequired
    public void saveCard(
            @ModelAttribute SaveCardRequest request,
            @RequestAttribute String user
    ) {
        saveCardService.execute(request, user);
    }

}
