package com.stac.daijin.global.interceptor;

import com.stac.daijin.domain.auth.exception.AuthenticationFailedException;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.global.annotation.AuthRequired;
import com.stac.daijin.global.lib.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception{
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthRequired authAnnotation = handlerMethod.getMethodAnnotation(AuthRequired.class);
        if (authAnnotation == null) {
            return true;
        }
        String token = extract(request);
        if (token == null || token.length() == 0) {
            throw AuthenticationFailedException.EXCEPTION;
        }
        User user = jwtProvider.validateToken(token);

        System.out.println("user : " + user.getAccountId());

        request.setAttribute("user", user.getAccountId());

        return true;
    }

    private String extract(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ","");
        }
        return null;
    }
}
