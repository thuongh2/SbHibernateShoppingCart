package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User getUser(String username);

    List<User> getUsers();

}
