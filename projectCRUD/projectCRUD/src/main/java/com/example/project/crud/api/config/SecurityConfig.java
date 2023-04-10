package com.example.project.crud.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChainAuthentication(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) // Login com browser e Form
                .httpBasic(Customizer.withDefaults()); // Login com Insomnia e Basic Auth
        return http.build();
    }

    //disabilitar o csrf para voltar a solicitação de logout
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
