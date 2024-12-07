package com.example.rest.controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/clients/**", "/api/chambres/**", "/api/reservations/**").permitAll()  // Allow public access to these endpoints
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }
}
