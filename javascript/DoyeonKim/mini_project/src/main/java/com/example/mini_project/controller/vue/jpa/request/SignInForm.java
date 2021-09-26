package com.example.mini_project.controller.vue.jpa.request;

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

    public com.example.mini_project.controller.vue.jpa.request.SignInRequest toSignInRequest() {
        return new com.example.mini_project.controller.vue.jpa.request.SignInRequest(email, password);
    }
}