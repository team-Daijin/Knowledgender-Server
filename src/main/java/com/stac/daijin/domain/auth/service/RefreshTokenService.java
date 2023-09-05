package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.RefreshToken;
import com.stac.daijin.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.stac.daijin.domain.auth.repository.RefreshTokenRepository;
import com.stac.daijin.global.security.jwt.JwtProvider;
import com.stac.daijin.global.security.jwt.enums.JwtType;
import com.stac.daijin.global.security.jwt.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public AccessTokenResponse execute(
            final String token
    ) {
        RefreshToken refreshToken = refreshTokenRepository.findById(token)
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
        return new AccessTokenResponse(
                jwtProvider.createToken(JwtType.ACCESS, refreshToken.getAccountId())
        );
    }

}
