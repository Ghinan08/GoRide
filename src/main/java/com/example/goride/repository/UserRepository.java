package com.example.goride.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.goride.model.User;

@Service
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User((long) 1, "John Doe", 123456789, "john@example.com"));
        users.add(new User((long) 2, "Sari", 812345679, "sari@example.com"));
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> Objects.equals(u.getId(), id)).findFirst();
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
