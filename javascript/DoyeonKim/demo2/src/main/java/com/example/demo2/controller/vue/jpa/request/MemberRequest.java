package com.example.demo2.controller.vue.jpa.request;

import com.example.demo2.entity.jpa.Member;
import com.example.demo2.entity.jpa.MemberAuth;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String auth;

    public MemberRequest(String userId, String password, String auth) {
        this.userId = userId;
        this.password = password;
        this.auth = auth;
    }
}