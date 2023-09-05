package com.stac.daijin.global.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends BusinessException{
    public static final BusinessException EXCEPTION = new InternalServerException();

    public InternalServerException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류");
    }
}
