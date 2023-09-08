package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.user.enums.Role;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserAccountIdExistsException;
import com.stac.daijin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(
            final RegisterUserRequest request
    ) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAccountIdExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .age(request.getAge())
                .gender(request.getGender())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
    }

}
