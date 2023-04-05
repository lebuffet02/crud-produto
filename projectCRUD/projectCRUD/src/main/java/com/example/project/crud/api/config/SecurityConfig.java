package com.example.project.crud.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChainAuthentication(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //disabilitar o csrf para voltar a solicitação de logout
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
