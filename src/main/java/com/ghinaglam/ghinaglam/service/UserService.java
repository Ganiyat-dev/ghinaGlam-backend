package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User createUser(User user);

    List<User> getUsers();

    Optional<User> getUser(String email);

    void deleteUser(String email);
}
