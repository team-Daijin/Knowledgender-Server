package com.stac.daijin.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("관리자"),
    EXPORT("전문가"),
    USER("사용자");

    private final String value;
}
