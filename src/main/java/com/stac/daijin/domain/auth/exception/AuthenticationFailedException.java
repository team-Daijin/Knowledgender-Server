package com.stac.daijin.domain.auth.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class AuthenticationFailedException extends BusinessException {

    public static final BusinessException EXCEPTION = new AuthenticationFailedException();


    public AuthenticationFailedException() {
        super(HttpStatus.BAD_REQUEST, "인증에 실패했습니다");
    }
}
