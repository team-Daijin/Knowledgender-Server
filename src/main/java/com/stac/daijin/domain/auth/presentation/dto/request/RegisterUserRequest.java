package com.stac.daijin.domain.auth.presentation.dto.request;

import com.stac.daijin.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterUserRequest {
    private String accountId;
    private String password;
    private String name;
    private int age;
    private Gender gender;

}
