package com.example.project.service.jpa;

import com.example.project.controller.vue.jpa.request.SignInForm;
import com.example.project.entity.jpa.Account;
import com.example.project.repository.jpa.JpaAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(SignInForm form) throws Exception {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        form.setPassword(encodedPassword);

        Account accountEntity = new Account(form.getEmail(), form.getPassword());

        accountRepository.save(accountEntity);
    }
}
