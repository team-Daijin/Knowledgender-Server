package com.stac.daijin.domain.user.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당유저를 찾지못했습니다");
    }
}
