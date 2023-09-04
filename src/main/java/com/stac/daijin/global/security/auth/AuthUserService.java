package com.stac.daijin.global.security.auth;

import com.stac.daijin.domain.user.exception.UserNotFoundException;
import com.stac.daijin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String accountId
    ) throws UsernameNotFoundException {
        return userRepository.findByAccountId(accountId)
                .map(AuthUser::new)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
