package com.stac.daijin.domain.user.service;

import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryUserByIdService {
    private final UserFacade userFacade;

    public UserResponse execute(
            String accountId
    ) {
        User user = userFacade.findUserByAccountId(accountId);
        return new UserResponse(
                user.getName(), user.getAge(), user.getGender().getGender()
        );
    }


}
