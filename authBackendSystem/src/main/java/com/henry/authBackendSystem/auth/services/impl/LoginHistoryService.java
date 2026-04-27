package com.henry.authBackendSystem.auth.services.impl;

import com.henry.authBackendSystem.auth.entities.LoginHistory;
import com.henry.authBackendSystem.auth.entities.User;
import com.henry.authBackendSystem.auth.repositories.LoginHistoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public void recordLogin(User user, HttpServletRequest request, String status) {
        String userAgent = request.getHeader("User-Agent");
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }

        // Simplistic device/platform detection for now
        String platform = "Unknown";
        String device = "Unknown";
        
        if (userAgent != null) {
            String lowerUA = userAgent.toLowerCase();
            if (lowerUA.contains("windows")) platform = "Windows";
            else if (lowerUA.contains("mac")) platform = "Mac OS";
            else if (lowerUA.contains("linux")) platform = "Linux";
            else if (lowerUA.contains("android")) platform = "Android";
            else if (lowerUA.contains("iphone")) platform = "iOS";

            if (lowerUA.contains("mobi")) device = "Mobile";
            else device = "Desktop";
        }

        LoginHistory history = LoginHistory.builder()
                .user(user)
                .loginTime(LocalDateTime.now())
                .platform(platform)
                .device(device)
                .ipAddress(ipAddress)
                .status(status)
                .location("Unknown") // Location would require a GeoIP service
                .build();

        loginHistoryRepository.save(history);
    }

    public List<LoginHistory> getLoginHistory(User user) {
        return loginHistoryRepository.findByUserOrderByLoginTimeDesc(user);
    }
}
