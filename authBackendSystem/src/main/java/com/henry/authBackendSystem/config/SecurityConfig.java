package com.henry.authBackendSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Disabled to prevent duplicate PasswordEncoder beans overriding global Spring Security defaults
// @Configuration("appSecurityConfig")
public class SecurityConfig {




    @Bean("appPasswordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }

    @Bean("appAuthenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
