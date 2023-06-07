package com.jydev.backend.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberRegisterRequest {
    private String email;
    private String password;
    private String nickname;
}
