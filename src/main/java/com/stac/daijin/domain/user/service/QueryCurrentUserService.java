package com.stac.daijin.domain.user.service;

import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryCurrentUserService {
    private final UserFacade userFacade;

    public UserResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserResponse(
                user.getName(), user.getAge(), user.getGender() == null ? "" : user.getGender().getGender()
        );
    }


}
