package com.toy.toyproject.api.service.member;

import com.toy.toyproject.domain.member.entity.Member;
import com.toy.toyproject.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(String name) {
        memberRepository.save(new Member(name));
    }

}
