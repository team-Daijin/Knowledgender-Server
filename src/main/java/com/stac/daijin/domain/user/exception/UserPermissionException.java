package com.stac.daijin.domain.user.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserPermissionException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserPermissionException();

    public UserPermissionException() {
        super(HttpStatus.BAD_REQUEST, "사용자의 권한이 부족합니다.");
    }
}
