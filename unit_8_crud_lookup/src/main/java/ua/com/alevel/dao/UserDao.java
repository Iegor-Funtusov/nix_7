package ua.com.alevel.dao;

import ua.com.alevel.entity.User;

import java.util.List;

public interface UserDao {

    void create(User user);
    void update(User user);
    void delete(String id);
    User findById(String id);
    List<User> findAll();
    boolean existByEmail(String email);
    boolean existById(String id);
    User findUserIdByEmailAndPassword(String email, String password);
}
