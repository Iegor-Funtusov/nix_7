package ua.com.alevel.unit_api_web.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.unit_api_web.db.UserDB;
import ua.com.alevel.unit_api_web.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void create(User user) {
        UserDB.getInstance().create(user);
    }

    @Override
    public void delete(String id) {
        UserDB.getInstance().delete(id);
    }

    @Override
    public User findById(String id) {
        return UserDB.getInstance().findById(id);
    }

    @Override
    public List<User> findAll() {
        return UserDB.getInstance().findAll();
    }
}
