package com.henry.authBackendSystem.auth.config;

public class AppConstants {


    public static final String[] AUTH_PUBLIC_URLS = {
            "/api/v1/auth/login",
            "/api/v1/auth/register",
            "/api/v1/auth/refresh",
            "/v3/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/error",
            // Frontend static files and routes
            "/",
            "/index.html",
            "/assets/**",
            "/vite.svg",
            "/favicon.ico",
            "/login",
            "/signup",
            "/dashboard",
            "/profile",
            "/oauth2/**"
    };

    public static final String[] AUTH_ADMIN_URLS= {
            "/api/v1/users/**"
    };

    public static final String[] AUTH_GUEST_URLS= {

    };

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String GUEST_ROLE = "GUEST";

//    other project-related constants


}
