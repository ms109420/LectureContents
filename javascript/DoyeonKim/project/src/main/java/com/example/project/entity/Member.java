package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {
    private Integer memberNo;
    private String id;
    private String pw;
    private Date regDate;
}