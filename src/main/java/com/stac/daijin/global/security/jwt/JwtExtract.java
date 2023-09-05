package com.stac.daijin.global.security.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtExtract {
    public String execute(HttpServletRequest request) {
        return extract(request.getHeader("Authorization"));
    }

    public String execute(String bearerToken) {
        return extract(bearerToken);
    }

    private String extract(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "");
        }
        return null;
    }

}
