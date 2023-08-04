package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.presentation.dto.request.RegisterExportRequest;
import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.user.Role;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserAccountIdExistsException;
import com.stac.daijin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterExportService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(RegisterExportRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAccountIdExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()))
                .name(request.getName())
                .job(request.getJob())
                .role(Role.EXPORT)
                .build();
        userRepository.save(user);
    }

}
