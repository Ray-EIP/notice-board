package com.jydev.backend.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberLoginRequest {
    private String email;
    private String password;
}
