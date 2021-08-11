package ua.com.alevel.dao.impl;

import ua.com.alevel.bd.ListBD;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user) {
        ListBD.getInstance().create(user);
    }

    @Override
    public void update(User user) {
        ListBD.getInstance().update(user);
    }

    @Override
    public void delete(String id) {
        ListBD.getInstance().delete(id);
    }

    @Override
    public User findById(String id) {
        return ListBD.getInstance().findById(id);
    }

    @Override
    public List<User> findAll() {
        return ListBD.getInstance().findAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return ListBD.getInstance().existByEmail(email);
    }

    @Override
    public boolean existById(String id) {
        return false;
    }

    @Override
    public User findUserIdByEmailAndPassword(String email, String password) {
        return ListBD.getInstance().findUserIdByEmailAndPassword(email, password);
    }
}
