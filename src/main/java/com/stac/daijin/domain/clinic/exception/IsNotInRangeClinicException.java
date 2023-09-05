package com.stac.daijin.domain.clinic.exception;


import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class IsNotInRangeClinicException extends BusinessException {
    public static final BusinessException EXCEPTION = new IsNotInRangeClinicException();

    public IsNotInRangeClinicException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 위도, 경도 입니다.");
    }
}
