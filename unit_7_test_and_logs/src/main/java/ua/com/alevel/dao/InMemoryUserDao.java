package ua.com.alevel.dao;

import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryUserDao {

    private final List<User> users = new ArrayList<>();

    public void create(User user) {
        user.setId(generateId());
        users.add(user);
    }

    public void update(User user) {
        User inDbUser = findUserById(user.getId());
        inDbUser.setAge(user.getAge());
        inDbUser.setName(user.getName());
        users.add(user);
    }

    public void delete(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User findUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public List<User> findAllUsers() {
        return users;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (users.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
