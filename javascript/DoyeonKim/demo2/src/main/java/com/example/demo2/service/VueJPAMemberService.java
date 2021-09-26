package com.example.demo2.service;

import com.example.demo2.entity.Member;
import com.example.demo2.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    // public void login(VueMember member) throws Exception;
    // public List<VueMember> list() throws Exception;
}
