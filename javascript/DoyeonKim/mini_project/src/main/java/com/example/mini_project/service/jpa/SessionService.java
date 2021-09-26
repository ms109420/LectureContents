package com.example.mini_project.service.jpa;

import com.example.mini_project.controller.vue.jpa.request.SaveUserRequest;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}
