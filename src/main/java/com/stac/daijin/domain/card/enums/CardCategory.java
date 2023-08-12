package com.stac.daijin.domain.card.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CardCategory {
    HEART("마음"),
    BODY("신체"),
    CRIME("범죄"),
    RELATIONSHIP("관계"),
    EQUALITY("평등");

    private final String value;
}
