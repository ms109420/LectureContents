package com.example.demo2.controller.vue.jpa.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SignInRequest {

    private String email;
    private String password;
    private String name;
    private String passwordpa;

    public SignInRequest(String email, String password, String name, String passwordpa) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.passwordpa = passwordpa;
    }
}