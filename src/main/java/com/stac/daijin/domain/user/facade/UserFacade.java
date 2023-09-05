package com.stac.daijin.domain.user.facade;

import com.corundumstudio.socketio.SocketIOClient;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.exception.UserNotFoundException;
import com.stac.daijin.domain.user.repository.UserRepository;
import com.stac.daijin.global.security.auth.AuthUser;
import com.stac.daijin.global.socket.config.property.SocketStoreKey;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    public User getCurrentUser() {
        AuthUser auth = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }
    @Transactional(readOnly = true)
    public User findUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findUserByClient(SocketIOClient client) {
        return userRepository.findByAccountId(client.get(SocketStoreKey.USER_KEY))
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
