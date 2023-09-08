package com.stac.daijin.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_ADMIN("ADMIN"),
    ROLE_EXPORT("EXPORT"),
    ROLE_USER("USER");

    private final String value;
}
