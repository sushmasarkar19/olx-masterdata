package com.sushma.olxmasterdata.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Configuration for olx-masterdata microservice.
 * 
 * This service is stateless and public in nature:
 * - All endpoints are accessible without authentication
 * - It serves lookup data (categories, statuses)
 * - Other services call these endpoints internally
 * 
 * The API Gateway still validates JWT for routes that call this service,
 * but olx-masterdata itself doesn't need to validate tokens.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] PUBLIC_PATHS = {
        "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs",
        "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**",
        "/webjars/**", "/actuator/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            .authorizeHttpRequests(auth -> auth
                
                // ── Swagger UI (always public) ────────────────────────────
                .requestMatchers(PUBLIC_PATHS).permitAll()
                
                // ── All other endpoints are public ────────────────────────
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
