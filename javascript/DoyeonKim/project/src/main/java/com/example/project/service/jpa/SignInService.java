package com.example.project.service.jpa;

import com.example.project.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}