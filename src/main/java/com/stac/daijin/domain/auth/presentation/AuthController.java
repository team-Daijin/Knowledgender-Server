package com.stac.daijin.domain.auth.presentation;

import com.stac.daijin.domain.auth.presentation.dto.request.LoginRequest;
import com.stac.daijin.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.stac.daijin.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginTokenResponse login(
            @RequestBody LoginRequest request
    ) {
        return loginService.execute(request);
    }

}
