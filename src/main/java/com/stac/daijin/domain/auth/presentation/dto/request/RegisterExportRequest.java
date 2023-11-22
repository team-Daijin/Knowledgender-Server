package com.stac.daijin.domain.auth.presentation.dto.request;

import com.stac.daijin.domain.user.domain.type.Job;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterExportRequest {
    private String accountId;
    private String password;
    private String name;
    private Job job;
}
