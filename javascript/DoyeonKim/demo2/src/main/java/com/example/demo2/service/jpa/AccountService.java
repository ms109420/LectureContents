package com.example.demo2.service.jpa;

import com.example.demo2.controller.vue.jpa.request.MemberRequest;
import com.example.demo2.controller.vue.jpa.request.SignInForm;
import com.example.demo2.entity.jpa.Member;

import java.util.Optional;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}