package ua.com.alevel.service;

import ua.com.alevel.dao.InMemoryUserDao;
import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final InMemoryUserDao userDao = new InMemoryUserDao();

    public void create(User user) {
        if (checkedAgeCorrectly(user.getAge())) {
            userDao.create(user);
        }
    }

    private boolean max(Integer integer) {
        return integer > 0;
    }

    public void update(User user) {
        if (checkedAgeCorrectly(user.getAge())) {
            userDao.update(user);
        }
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public boolean checkedAgeCorrectly(int age) {
        return age >= 0 && age < 100;
    }
}
