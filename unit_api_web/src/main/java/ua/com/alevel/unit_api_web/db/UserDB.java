package ua.com.alevel.unit_api_web.db;

import ua.com.alevel.unit_api_web.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDB {

    private static UserDB instance;

    private UserDB() {}

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    private final List<User> users = new ArrayList<>();

    public void create(final User user) {
        user.setId(generateId());
        users.add(user);
    }

    public void delete(final String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User findById(final String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public List<User> findAll() {
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
