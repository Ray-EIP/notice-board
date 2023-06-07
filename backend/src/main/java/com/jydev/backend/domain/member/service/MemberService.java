package com.jydev.backend.domain.member.service;

import com.jydev.backend.domain.member.dto.MemberDto;
import com.jydev.backend.domain.member.dto.MemberLoginRequest;
import com.jydev.backend.domain.member.dto.MemberRegisterRequest;
import com.jydev.backend.domain.member.entity.Member;
import com.jydev.backend.infrastructer.repository.MemberCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberCommandRepository memberRepository;

    public MemberDto registerMember(MemberRegisterRequest request){
        Member member = new Member(request);
        Member saveMember = memberRepository.save(member);
        return new MemberDto(saveMember);
    }

    public MemberDto loginMember(MemberLoginRequest request){
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("유저가 없습니다."));
        member.verifyLoginMember(request);
        return new MemberDto(member);
    }
}
