package com.stac.daijin.domain.card.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class CardNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new CardNotFoundException();

    public CardNotFoundException() {
        super(HttpStatus.NOT_FOUND, "카드뉴스를 찾지 못했습니다.");
    }
}
