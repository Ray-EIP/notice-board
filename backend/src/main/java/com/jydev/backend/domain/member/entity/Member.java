package com.jydev.backend.domain.member.entity;

import com.jydev.backend.domain.member.dto.MemberLoginRequest;
import com.jydev.backend.domain.member.dto.MemberRegisterRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    private String nickname;

    public Member(MemberRegisterRequest request){
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.nickname = request.getNickname();
    }

    public void verifyLoginMember(MemberLoginRequest request){
        if(!request.getPassword().equals(this.password))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }
}
