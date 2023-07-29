package com.stac.daijin.domain.auth.presentation;

import com.stac.daijin.domain.auth.presentation.dto.request.LoginUserRequest;
import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.stac.daijin.domain.auth.service.LoginUserService;
import com.stac.daijin.domain.auth.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUserService registerUserService;
    private final LoginUserService loginUserService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(
            @RequestBody RegisterUserRequest request
    ) {
        registerUserService.execute(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginTokenResponse loginUser(
            @RequestBody LoginUserRequest request
    ) {
        return loginUserService.execute(request);
    }
}
