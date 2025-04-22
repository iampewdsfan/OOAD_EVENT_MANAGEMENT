package com.example.collegeevent.repository;

import com.example.collegeevent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
