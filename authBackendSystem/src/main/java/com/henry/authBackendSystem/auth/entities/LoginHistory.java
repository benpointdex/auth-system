package com.henry.authBackendSystem.auth.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter 
@Setter 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    private LocalDateTime loginTime;
    private String platform;
    private String device;
    private String location;
    private String ipAddress;
    private String status; // SUCCESS, FAILED
}
