package com.stac.daijin.domain.user.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Job {
    DOCTER("의사"),
    COUNSELOR("상담사"),
    PHARMACIST("약사"),
    TEACHER("선생님"),
    ETC("기타");

    private final String value;
}
