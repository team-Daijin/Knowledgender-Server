package com.stac.daijin.domain.user.presentation;

import com.stac.daijin.domain.user.service.DeleteUserService;
import com.stac.daijin.domain.user.service.QueryUserByIdService;
import com.stac.daijin.global.annotation.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DeleteUserService deleteUserService;
    private final QueryUserByIdService queryUserService;

    @AuthRequired
    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(
            @RequestAttribute String user
            ) {
        deleteUserService.execute(user);
    }

    @AuthRequired
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void getUser(
            @RequestAttribute String user
    ) {
        queryUserService.execute(user);
    }
}
