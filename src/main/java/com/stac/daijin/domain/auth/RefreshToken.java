package com.stac.daijin.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Calendar;


@Getter
@AllArgsConstructor
@Builder
@RedisHash(timeToLive = 1209600)
public class RefreshToken {
    @Id
    private String refreshToken;

    private String accountId;
}
