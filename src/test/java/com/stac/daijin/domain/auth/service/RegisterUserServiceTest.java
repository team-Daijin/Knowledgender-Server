package com.stac.daijin.domain.auth.service;

import com.stac.daijin.domain.auth.presentation.dto.request.RegisterUserRequest;
import com.stac.daijin.domain.user.enums.Gender;
import com.stac.daijin.domain.user.enums.Role;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterUserServiceTest {

    @InjectMocks
    private RegisterUserService registerUserService;
    @Mock
    private UserRepository userRepository;

    private final User exampleUser = User.builder()
            .accountId("exampleUser")
            .password("exampleUser1234")
            .name("예시임")
            .age(23)
            .gender(Gender.MALE)
            .role(Role.USER)
            .build();

    @DisplayName("회원가입 테스트")
    @Test
    void execute() {
        given(userRepository.save(any())).willReturn(exampleUser);
        //given(BCrypt.hashpw(anyString(), BCrypt.gensalt())).willReturn("exampleUser1234");
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        registerUserService.execute(
                new RegisterUserRequest(
                        "exampleUser",
                        "exampleUser1234",
                        "예시임",
                        23,
                        Gender.MALE
                )
        );

        verify(userRepository, times(1)).save(captor.capture());
        User savedUser = captor.getValue();
        assertEquals("exampleUser", savedUser.getAccountId());
        //assertEquals("exampleUser1234", savedUser.getPassword());
        assertEquals("예시임", savedUser.getName());
        assertEquals(23, savedUser.getAge());
        assertEquals(Gender.MALE, savedUser.getGender());
        assertEquals(Role.USER, Role.USER);
    }
}