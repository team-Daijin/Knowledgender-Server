package com.stac.daijin.thirdparty.s3.exception;

import com.stac.daijin.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class S3FailedFileSaveException extends BusinessException {

    public static final BusinessException EXCEPTION = new S3FailedFileSaveException();

    private S3FailedFileSaveException() {
        super(HttpStatus.BAD_REQUEST, "파일을 저장하는데 실패 했습니다.");
    }
}
