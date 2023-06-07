package com.jydev.backend.infrastructer.web;

import com.jydev.backend.domain.member.dto.MemberDto;
import com.jydev.backend.domain.member.dto.MemberLoginRequest;
import com.jydev.backend.domain.member.dto.MemberRegisterRequest;
import com.jydev.backend.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public MemberDto login(MemberLoginRequest request, HttpServletRequest httpRequest){
        MemberDto memberDto = memberService.loginMember(request);
        HttpSession session = httpRequest.getSession();
        session.setAttribute("member",memberDto);
        return memberDto;
    }

    @PostMapping("/register")
    public MemberDto register(@RequestBody MemberRegisterRequest request){
        MemberDto response = memberService.registerMember(request);
        return response;
    }
}
