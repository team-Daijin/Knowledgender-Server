package com.stac.daijin.domain.auth.presentation;

import com.stac.daijin.domain.auth.presentation.dto.request.RegisterExportRequest;
import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.auth.service.RegisterExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/export")
@RequiredArgsConstructor
public class ExportAuthController {

    private final RegisterExportService registerExportService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(
            @RequestBody RegisterExportRequest request
    ) {
        registerExportService.execute(request);
    }
}
