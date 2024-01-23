package com.toy.toyproject.api.controller.member;

import com.toy.toyproject.api.service.member.MemberService;
import com.toy.toyproject.domain.member.entity.Member;
import com.toy.toyproject.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void save() {
        memberService.save("김민수");
    }

}
