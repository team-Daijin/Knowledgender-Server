package com.stac.daijin.domain.clinic.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ClinicNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ClinicNotFoundException();

    public ClinicNotFoundException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 상담소 ");
    }
}
