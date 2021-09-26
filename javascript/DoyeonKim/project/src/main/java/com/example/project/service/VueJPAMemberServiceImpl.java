package com.example.project.service;

import com.example.project.entity.Member;
import com.example.project.entity.VueMember;
import com.example.project.repository.VueJPAMemberRepository;
import com.example.project.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception {
        repository.save(member);
    }
}