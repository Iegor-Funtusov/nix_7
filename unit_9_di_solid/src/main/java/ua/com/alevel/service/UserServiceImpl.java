package ua.com.alevel.service;

import org.diframework.annotation.BeanClass;
import org.diframework.annotation.InjectBean;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

@BeanClass
public class UserServiceImpl implements UserService {

    @InjectBean
    private UserDao userDao;

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
