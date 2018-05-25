package by.my.service;

import by.my.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}