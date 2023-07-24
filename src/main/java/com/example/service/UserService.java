package com.example.service;


import com.example.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(Long id);

    User get(Long id);

    List<User> getAll();
}