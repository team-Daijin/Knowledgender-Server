package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.RefreshToken;
import com.stac.daijin.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.stac.daijin.domain.auth.repository.RefreshTokenRepository;
import com.stac.daijin.global.lib.JwtProvider;
import com.stac.daijin.global.lib.JwtType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public AccessTokenResponse execute(
            String token
    ) {
        RefreshToken refreshToken = refreshTokenRepository.findById(token)
                .orElseThrow(() -> new RuntimeException("토큰 못찾음"));
        return new AccessTokenResponse(
                jwtProvider.createToken(JwtType.ACCESS, refreshToken.getAccountId())
        );
    }

}
