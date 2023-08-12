package com.stac.daijin.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
    MALE("남자"),
    FEMALE("여자");

    private final String gender;
}
