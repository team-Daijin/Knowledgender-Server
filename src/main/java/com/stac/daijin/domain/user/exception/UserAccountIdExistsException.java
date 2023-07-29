package com.stac.daijin.domain.user.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserAccountIdExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserAccountIdExistsException();

    public UserAccountIdExistsException() {
        super(HttpStatus.BAD_REQUEST, "이미 존재하는 계정아디 입니다.");
    }
}
