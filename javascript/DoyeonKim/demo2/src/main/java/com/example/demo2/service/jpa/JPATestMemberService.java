package com.example.demo2.service.jpa;

import com.example.demo2.controller.vue.jpa.request.MemberRequest;
import com.example.demo2.entity.jpa.TestMember;

import java.util.List;

public interface JPATestMemberService {

    public List<TestMember> findByJPQL() throws Exception;
    public List<Object[]> findSpecificByJPQL() throws Exception;
}
