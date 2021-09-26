package com.example.demo2.controller.vue.jpa.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInForm {

    private String email;
    private String password;
    private String passwordpa;
    private String name;


    public SignInRequest toSignInRequest() {
        return new SignInRequest(email, password, passwordpa, name );
    }
}