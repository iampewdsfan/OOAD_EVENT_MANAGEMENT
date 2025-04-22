package com.example.collegeevent.repository;

import com.example.collegeevent.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}