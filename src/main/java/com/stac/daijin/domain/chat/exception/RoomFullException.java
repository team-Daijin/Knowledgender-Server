package com.stac.daijin.domain.chat.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class RoomFullException extends BusinessException {
    public static final BusinessException EXCEPTION = new RoomFullException();


    public RoomFullException() {
        super(HttpStatus.BAD_REQUEST, "이미 인원이 꽉찬 방입니다.");
    }
}
