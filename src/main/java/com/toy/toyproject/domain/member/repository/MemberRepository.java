package com.toy.toyproject.domain.member.repository;

import com.toy.toyproject.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
