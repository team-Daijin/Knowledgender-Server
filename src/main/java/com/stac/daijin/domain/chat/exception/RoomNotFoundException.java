package com.stac.daijin.domain.chat.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class RoomNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new RoomNotFoundException();


    public RoomNotFoundException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 방 입니다.");
    }
}
