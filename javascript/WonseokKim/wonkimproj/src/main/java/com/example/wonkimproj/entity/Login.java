package com.example.wonkimproj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Login {
    private int loginNo;
    private String id;
    private String pw;
    private Date regDate;
}
