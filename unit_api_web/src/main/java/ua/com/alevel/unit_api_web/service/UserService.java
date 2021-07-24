package ua.com.alevel.unit_api_web.service;

import ua.com.alevel.unit_api_web.domain.User;

import java.util.List;

public interface UserService {

    void create(final User user);
    void delete(final String id);
    User findById(final String id);
    List<User> findAll();
}
