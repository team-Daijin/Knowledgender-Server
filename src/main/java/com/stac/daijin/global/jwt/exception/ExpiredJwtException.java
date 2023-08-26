package com.stac.daijin.global.jwt.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ExpiredJwtException extends BusinessException {
    public static final BusinessException EXCEPTION = new ExpiredJwtException();

    public ExpiredJwtException() {
        super(HttpStatus.UNAUTHORIZED, "만료된 토큰 입니다.");
    }
}
