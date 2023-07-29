package com.stac.daijin.domain.user.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserPasswordNotMatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();


    public UserPasswordNotMatchException() {
        super(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다");
    }
}
