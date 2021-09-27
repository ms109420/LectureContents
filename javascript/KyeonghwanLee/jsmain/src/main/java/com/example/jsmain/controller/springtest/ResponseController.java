package com.example.jsmain.controller.springtest;


import com.example.jsmain.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
// RestController json 형태로 객체를 반환 즉 post처럼 동작시키겠다.
public class ResponseController {

    @GetMapping("/jsonMember")
    public Member jsonMember(){
        log.info("jsonMember()");

        Member member = new Member();
        member.setId("name");
        member.setPw("test");

        return member;
    }

    @GetMapping("/jsonListMember")
    public List<Member> jsonListMember (){
        log.info ("jsonListMember");

        List<Member> list = new ArrayList<>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        list.add(member1);

        Member member2 = new Member();
        member2.setId("name2");
        member2.setPw("test2");
        list.add(member2);

        return list;
    }

    @GetMapping("/jsonHashMapMember")
    public Map<String, Member> jsonHashMapMember (){
        log.info ("jsonHashMapMember");

        Map<String, Member> map = new HashMap<String, Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        map.put("key1", member1);

        Member member2 = new Member();
        member2.setId("name2");
        member2.setPw("test2");
        map.put("key2", member2);

        return map;
    }

    @GetMapping("/jsonVoid")
    public ResponseEntity<Void> jsonVoid (){
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/jsonString")
    public ResponseEntity<String> jsonString (){
        log.info("jsonString()");

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}
