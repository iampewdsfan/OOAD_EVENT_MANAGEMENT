package com.example.collegeevent.repository;

import com.example.collegeevent.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}