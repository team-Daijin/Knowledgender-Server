package com.stac.daijin.domain.user.service;

import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        userRepository.deleteByAccountId(userFacade.getCurrentUser().getAccountId());
    }

}
