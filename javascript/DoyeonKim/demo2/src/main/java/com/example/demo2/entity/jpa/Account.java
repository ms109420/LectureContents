package com.example.demo2.entity.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Entity
@Table
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String email;

    @Getter
    @Column(nullable = false)
    private String password;

    @Getter
    @Column(nullable = false)
    private String passwordpa;

    @Getter
    @Column(nullable = false)
    private String name;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.passwordpa = passwordpa;
    }
}
