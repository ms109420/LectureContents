package com.example.demo.eutity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private int boardNo;
    private String title;
    // th:filed로 맵핑됨
    private String content;
    private String writer;
    private Date regDate;


}
/*
    create table member(
            member_no int not null auto_increment,
            user_id varchar(20) not null,
            user_pass varchar(20) not null,
             name varchar(10) not null,
             sex varchar(10) not null,
            phone_no varchar(11) not null,dateOfBirth date not null ,
            join_date timestamp not null default now(),
            primary key(member_no));

 */