package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.presentation.dto.request.LoginUserRequest;
import com.stac.daijin.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserNotFoundException;
import com.stac.daijin.domain.user.exception.UserPasswordNotMatchException;
import com.stac.daijin.domain.user.repository.UserRepository;
import com.stac.daijin.global.lib.JwtProvider;
import com.stac.daijin.global.lib.JwtType;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginUserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Transactional
    public LoginTokenResponse execute(LoginUserRequest request){
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw UserPasswordNotMatchException.EXCEPTION;
        }

        return new LoginTokenResponse(
                jwtProvider.createToken(JwtType.ACCESS, user.getAccountId()),
                jwtProvider.createToken(JwtType.REFRESH, user.getAccountId())
        );
    }
}
