package com.example.SoloProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {
    private int memberNo;
    private String name;
    private String id;
    private String pw;
    private Date regDate;
}
