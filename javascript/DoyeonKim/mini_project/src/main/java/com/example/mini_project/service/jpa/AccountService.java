package com.example.mini_project.service.jpa;

import com.example.mini_project.controller.vue.jpa.request.SignInForm;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}