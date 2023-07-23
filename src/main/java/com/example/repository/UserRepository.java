package com.example.repository;


import com.example.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        if (Objects.isNull(user.getId())) {
            em.persist(user);
            return user;
        }
        return Objects.isNull(findById(user.getId())) ? null : em.merge(user);
    }

    public void deleteById(Long id) {
        em.createQuery("DELETE FROM User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public List<User> getAll() {
        return em.createQuery("FROM User", User.class).getResultList();
    }
}