package com.jydev.backend.infrastructer.repository;

import com.jydev.backend.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberCommandRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
