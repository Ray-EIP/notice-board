package com.jydev.backend.domain.member.dto;

import com.jydev.backend.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private String email;
    private String nickname;

    public MemberDto(Member member){
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }
}
