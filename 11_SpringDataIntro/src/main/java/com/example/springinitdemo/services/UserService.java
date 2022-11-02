package com.example.springinitdemo.services;

import com.example.springinitdemo.models.User;

public interface UserService {
    void register(String username, int age);

    User findByUsername(String username);
}
