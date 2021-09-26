package com.example.demo2.controller.vue.jpa.request;

import lombok.Getter;

@Getter
public class SaveUserRequest {

    private String email;

    public SaveUserRequest(String email) {
        this.email = email;
    }

    public SessionUser toSessionUser() {
        return new SessionUser(email);
    }
}