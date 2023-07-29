package com.stac.daijin.domain.auth.presentation.dto.request;

import com.stac.daijin.domain.user.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterUserRequest {
    private String accountId;
    private String password;
    private String name;
    private int age;
    private Gender gender;

}
