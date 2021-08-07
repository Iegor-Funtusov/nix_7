package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.alevel.dao.InMemoryUserDao;
import ua.com.alevel.entity.User;

import java.util.List;

public class UserService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private final InMemoryUserDao userDao = new InMemoryUserDao();

    public void create(User user) {
        LOGGER_INFO.info("create new user: " + user.getName());
        if (checkedAgeCorrectly(user.getAge())) {
            userDao.create(user);
        }
    }

    public void update(User user) {
        if (checkedAgeCorrectly(user.getAge())) {
            userDao.update(user);
        }
    }

    public void delete(String id) {
        LOGGER_WARN.warn("remove user by id: " + id);
        userDao.delete(id);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    private boolean checkedAgeCorrectly(int age) {
        return age >= 0 && age < 100;
    }
}
