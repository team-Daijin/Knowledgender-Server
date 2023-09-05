package com.stac.daijin.global.security.jwt;

import com.stac.daijin.domain.auth.RefreshToken;
import com.stac.daijin.domain.auth.repository.RefreshTokenRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.global.security.jwt.enums.JwtType;
import com.stac.daijin.global.security.jwt.exception.ExpiredJwtException;
import com.stac.daijin.global.security.jwt.exception.InvalidTokenException;
import com.stac.daijin.global.security.jwt.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    public Key getSigningKey(String jwtKey) {
        byte[] keyBytes = jwtKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(
            final JwtType jwtType,
            final String accountId
    ) {
        Instant now = Instant.now();
        Duration expiration = Duration.ZERO;
        String secretKey = "";

        switch(jwtType) {
            case ACCESS:
                expiration = expiration.plus(Duration.ofDays(7));
                secretKey = jwtProperties.getAccessKey();
                break;
            case REFRESH:
                expiration = expiration.plus(Duration.ofDays(14));
                secretKey = jwtProperties.getRefreshKey();
                break;
        }

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("accountId", accountId);

        String token = Jwts.builder().setHeaderParams(headerMap)
                .setClaims(claimsMap)
                .setExpiration(Date.from(now.plus(expiration)))
                .signWith(getSigningKey(secretKey), SignatureAlgorithm.HS256)
                .compact();

        if (jwtType.equals(JwtType.REFRESH)) {
            RefreshToken refreshToken = RefreshToken.builder()
                    .refreshToken(token)
                    .accountId(accountId)
                    .build();
            refreshTokenRepository.save(refreshToken);
        }

        return token;
    }

    public User validateToken(String token) {
        try {
            return userFacade.findUserByAccountId(
                    Jwts.parserBuilder()
                            .setSigningKey(getSigningKey(jwtProperties.getAccessKey()))
                            .build()
                            .parseClaimsJws(token)
                            .getBody()
                            .get("accountId", String.class)
            );
        } catch (ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}