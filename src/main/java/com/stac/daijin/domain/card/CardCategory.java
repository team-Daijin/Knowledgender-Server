package com.stac.daijin.domain.card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CardCategory {
    GENDERISSUES("젠더 문제"),
    SEXUALASSAULTCOPE("성폭력 대처법"),
    BODY("신체"),
    RELATIONSHIP("친구 / 이성 관계"),
    MY("나");

    private final String value;
}
