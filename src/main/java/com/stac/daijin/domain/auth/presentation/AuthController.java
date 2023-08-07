package com.stac.daijin.domain.auth.presentation;

import com.stac.daijin.domain.auth.presentation.dto.request.LoginRequest;
import com.stac.daijin.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.stac.daijin.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.stac.daijin.domain.auth.service.LoginService;
import com.stac.daijin.domain.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginTokenResponse login(
            @RequestBody LoginRequest request
    ) {
        return loginService.execute(request);
    }

    @PutMapping("/refresh")
    public AccessTokenResponse refreshToken(
            @RequestHeader(value = "Refresh-Token") String refreshToken
    ) {
        return refreshTokenService.execute(refreshToken);
    }

}
