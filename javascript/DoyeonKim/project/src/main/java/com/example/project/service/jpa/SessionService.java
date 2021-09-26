package com.example.project.service.jpa;

import com.example.project.controller.vue.jpa.request.SaveUserRequest;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}
