package com.example.collegeevent.repository;

import com.example.collegeevent.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}