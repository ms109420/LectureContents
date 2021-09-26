package com.example.demo2.service.jpa;

import com.example.demo2.controller.vue.jpa.request.MemberRequest;
import com.example.demo2.entity.jpa.Member;

import java.util.List;
import java.util.Optional;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String userId) throws Exception;
    /*
    public List<Member> list() throws Exception;
     */

    public Optional<Member> findByAuth(Long memberNo);
}