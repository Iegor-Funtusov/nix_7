package ua.com.alevel.service.impl;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.SecurityUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void create(User user) {
        if (!userDao.existByEmail(user.getEmail())) {
            String password = SecurityUtil.hashPassword(user.getPassword());
            System.out.println("password = " + password);
            user.setPassword(password);
            userDao.create(user);
        }
    }

    @Override
    public void update(User user) {
        if (userDao.existById(user.getId())) {
            userDao.update(user);
        }
    }

    @Override
    public void delete(String id) {
        if (userDao.existById(id)) {
            userDao.delete(id);
        }
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
