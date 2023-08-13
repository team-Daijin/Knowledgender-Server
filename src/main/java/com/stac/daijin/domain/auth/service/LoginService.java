package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.presentation.dto.request.LoginRequest;
import com.stac.daijin.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserPasswordNotMatchException;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.global.jwt.JwtProvider;
import com.stac.daijin.global.jwt.enums.JwtType;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;

    @Transactional
    public LoginTokenResponse execute(
            final LoginRequest request
    ){
        User user = userFacade.getUserByAccountId(request.getAccountId());

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw UserPasswordNotMatchException.EXCEPTION;
        }

        return new LoginTokenResponse(
                jwtProvider.createToken(JwtType.ACCESS, user.getAccountId()),
                jwtProvider.createToken(JwtType.REFRESH, user.getAccountId())
        );
    }
}
