package com.example.demo2.service;

import com.example.demo2.entity.Member;
import com.example.demo2.entity.VueMember;
import com.example.demo2.repository.VueJPAMemberRepository;
import com.example.demo2.repository.VueMemberRepository;
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
