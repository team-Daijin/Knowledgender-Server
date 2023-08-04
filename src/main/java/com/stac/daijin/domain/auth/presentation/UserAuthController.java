package com.stac.daijin.domain.auth.presentation;

import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.auth.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UserAuthController {
    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(
            @RequestBody RegisterUserRequest request
    ) {
        registerUserService.execute(request);
    }


}
