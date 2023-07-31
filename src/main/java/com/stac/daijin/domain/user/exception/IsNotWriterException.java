package com.stac.daijin.domain.user.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class IsNotWriterException extends BusinessException {
    public static final BusinessException EXCEPTION = new IsNotWriterException();

    public IsNotWriterException() {
        super(HttpStatus.BAD_REQUEST, "사용자가 일치 하지 않음");
    }
}
