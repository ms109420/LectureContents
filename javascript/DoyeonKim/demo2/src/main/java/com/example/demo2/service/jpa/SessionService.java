package com.example.demo2.service.jpa;

import com.example.demo2.controller.vue.jpa.request.SaveUserRequest;
import com.example.demo2.controller.vue.jpa.request.SessionKey;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}