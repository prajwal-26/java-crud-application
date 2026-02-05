package com.prajwal.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    public User createUser(UserRequest request) {
        User user = new User(currentId++, request.getName(), request.getEmail());
        users.add(user);
        return user;
    }
    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public Optional<User> updateUser(Long id, UserRequest request) {
        Optional<User> userOpt = getUserById(id);
        userOpt.ifPresent(user -> {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
        });
        return userOpt;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
