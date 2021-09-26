package com.example.project.service;

import com.example.project.entity.Member;
import com.example.project.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    // public void login(VueMember member) throws Exception;
    // public List<VueMember> list() throws Exception;
}