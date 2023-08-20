package com.stac.daijin.domain.user.service;

import com.stac.daijin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {
    private final UserRepository userRepository;

    @Transactional
    public void execute(
            final String accountId
    ) {
        userRepository.deleteByAccountId(accountId);
    }

}
