package com.example.repository;


import com.example.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    void deleteById(Long id);

    User findById(Long id);

    List<User> getAll();
}