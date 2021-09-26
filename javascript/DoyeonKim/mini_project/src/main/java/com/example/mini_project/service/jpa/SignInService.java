package com.example.mini_project.service.jpa;

import com.example.mini_project.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}