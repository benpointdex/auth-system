package com.henry.authBackendSystem.auth.repositories;

import com.henry.authBackendSystem.auth.entities.LoginHistory;
import com.henry.authBackendSystem.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findByUserOrderByLoginTimeDesc(User user);
}
