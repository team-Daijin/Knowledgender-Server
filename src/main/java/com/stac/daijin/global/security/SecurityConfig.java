package com.stac.daijin.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stac.daijin.domain.user.enums.Role;
import com.stac.daijin.global.exception.filter.GlobalExceptionFilter;
import com.stac.daijin.global.security.auth.AuthUserService;
import com.stac.daijin.global.security.jwt.JwtAuthenticationFilter;
import com.stac.daijin.global.security.jwt.JwtExtract;
import com.stac.daijin.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtExtract jwtExtract;
    private final AuthUserService authUserService;
    private final JwtProvider jwtProvider;
    private final ObjectMapper objectMapper;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(
            HttpSecurity http
    ) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .cors()
                .configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOrigins(List.of("*"));
                    cors.setAllowedMethods(List.of(
                            HttpMethod.GET.name(),
                            HttpMethod.HEAD.name(),
                            HttpMethod.POST.name(),
                            HttpMethod.PUT.name(),
                            HttpMethod.DELETE.name(),
                            HttpMethod.PATCH.name()
                    ));
                    cors.setAllowedHeaders(
                            List.of(
                                    "Access-Control-Allow-Origin",
                                    "Content-Type",
                                    "Authorization"
                            )
                    );
                    cors.setMaxAge(3000L);
                    return cors;
                })

                .and()
                .authorizeRequests()
                //auth
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/auth/export/**").permitAll()
                .antMatchers("/api/auth/user/**").permitAll()
                //user
                .antMatchers(HttpMethod.GET, "/api/user/").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/user/").authenticated()
                //card
                .antMatchers(HttpMethod.POST, "/api/card/").hasRole(Role.ROLE_EXPORT.getValue())
                .antMatchers(HttpMethod.GET, "/api/card/").permitAll()
                .antMatchers(HttpMethod.GET,"/api/card/{\\d+}").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/card/{\\d+}").hasRole(Role.ROLE_EXPORT.getValue())
                .antMatchers(HttpMethod.DELETE, "/api/card/{\\d+}").hasRole(Role.ROLE_EXPORT.getValue())
                //clinic
                .antMatchers(HttpMethod.POST, "/api/clinic/").hasRole(Role.ROLE_EXPORT.getValue())
                .antMatchers(HttpMethod.GET, "/api/clinic/").permitAll()
                //appointment
                .antMatchers(HttpMethod.POST, "/api/appointment/").authenticated()
                .anyRequest().authenticated()

                .and()
                .addFilterBefore(
                        new JwtAuthenticationFilter(
                                jwtExtract, authUserService, jwtProvider
                        )
                        , UsernamePasswordAuthenticationFilter.class
                )
                .addFilterBefore(
                        new GlobalExceptionFilter(objectMapper),
                        JwtAuthenticationFilter.class
                );

        return http.build();
    }

}
