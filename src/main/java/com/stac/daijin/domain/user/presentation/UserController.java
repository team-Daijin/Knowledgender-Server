package com.stac.daijin.domain.user.presentation;

import com.stac.daijin.domain.user.presentation.dto.response.UserResponse;
import com.stac.daijin.domain.user.service.DeleteUserService;
import com.stac.daijin.domain.user.service.QueryCurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DeleteUserService deleteUserService;
    private final QueryCurrentUserService queryCurrentUserService;

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser() {
        deleteUserService.execute();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser() {
        return queryCurrentUserService.execute();
    }
}
