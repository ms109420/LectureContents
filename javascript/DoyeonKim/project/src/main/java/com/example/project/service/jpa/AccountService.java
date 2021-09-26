package com.example.project.service.jpa;

import com.example.project.controller.vue.jpa.request.SignInForm;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}