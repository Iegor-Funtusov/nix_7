package ua.com.alevel.unit_api_web.service;

import org.springframework.stereotype.Service;
//import ua.com.alevel.unit_api_web.db.UserDB;
import ua.com.alevel.unit_api_web.domain.User;
import ua.com.alevel.unit_api_web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
//        UserDB.getInstance().create(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
//        UserDB.getInstance().delete(id);
    }

    @Override
    public User findById(Integer id) {
//        return UserDB.getInstance().findById(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
//        return UserDB.getInstance().findAll();
        return userRepository.findAll();
    }
}
