package com.henry.authBackendSystem.auth.payload;

public record LoginRequest(
        String email,
        String password
) {
}
