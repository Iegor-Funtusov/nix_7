package ua.com.alevel.service;

import ua.com.alevel.entity.User;

import java.util.List;

public interface UserService {

    void create(User user);
    void update(User user);
    void delete(String id);
    User findById(String id);
    List<User> findAll();
}
