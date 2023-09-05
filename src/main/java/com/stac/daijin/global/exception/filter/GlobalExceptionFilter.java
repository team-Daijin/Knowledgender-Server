package com.stac.daijin.global.exception.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stac.daijin.global.exception.BusinessException;
import com.stac.daijin.global.exception.InternalServerException;
import com.stac.daijin.global.exception.response.ExceptionResponse;
import com.stac.daijin.global.security.jwt.exception.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GlobalExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            setErrorResponse(e, response);
        } catch (Exception e) {
            if (e.getCause() instanceof BusinessException) {
                setErrorResponse( (BusinessException) e.getCause(), response);
            } else {
                e.printStackTrace();
                setErrorResponse(InternalServerException.EXCEPTION, response);
            }
        }
    }

    private void setErrorResponse(
            BusinessException errorResponse,
            HttpServletResponse response
    ) throws IOException {
        response.setStatus(errorResponse.getHttpStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ExceptionResponse(errorResponse.getMessage())
                )
        );
    }

}
