package com.example.demo2.service.jpa;

import com.example.demo2.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}