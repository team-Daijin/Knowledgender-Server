package com.stac.daijin.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginTokenResponse {
    private String accessToken;
    private String refreshToken;
}
