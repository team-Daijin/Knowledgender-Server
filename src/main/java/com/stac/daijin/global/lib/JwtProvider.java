package com.stac.daijin.global.lib;

import com.stac.daijin.domain.auth.RefreshToken;
import com.stac.daijin.domain.auth.repository.RefreshTokenRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserNotFoundException;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.domain.user.repository.UserRepository;
import com.stac.daijin.global.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
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

    public String createToken(JwtType jwtType, String accountId) {
        Date nowDate = new Date();
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.setTime(nowDate);

        String secretKey = "";

        switch(jwtType) {
            case ACCESS:
                expiredDate.add(Calendar.DATE, 3);
                secretKey = jwtProperties.getAccessKey();
                break;
            case REFRESH:
                expiredDate.add(Calendar.DATE, 20);
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
                .setExpiration(expiredDate.getTime())
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
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey(jwtProperties.getAccessKey()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return userFacade.getUserByAccountId(claims.get("accountId", String.class));
    }
}