package com.example.service;


import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private UserRepository repository;

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User get(Long id) {
        return repository.findById(id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }
}