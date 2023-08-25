package com.stac.daijin.domain.user.facade;

import com.corundumstudio.socketio.SocketIOClient;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserNotFoundException;
import com.stac.daijin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findUserByClient(SocketIOClient client) {
        return userRepository.findByAccountId(client.get("user"))
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
