package ua.com.alevel.bd;

import ua.com.alevel.entity.Token;
import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListBD {

    private static final ListBD instance = new ListBD();
    private final List<User> users = new ArrayList<>();
    private final List<Token> tokens = new ArrayList<>();

    private ListBD() { }

    public static ListBD getInstance() {
        return instance;
    }

    public void create(User user) {
        user.setId(generateId(Entity.USER));
        users.add(user);
    }

    public void update(User user) {
        User current = findById(user.getId());
        current.setFirstName(user.getFirstName());
        current.setLastName(user.getLastName());
    }

    public void delete(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public List<User> findAll() {
        return users;
    }

    public boolean existByEmail(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public boolean existById(String id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }

    public User findById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public User findUserIdByEmailAndPassword(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }

    public void createToken(Token token) {
        token.setId(generateId(Entity.TOKEN));
        tokens.add(token);
    }

    public boolean existByToken(String token) {
        return tokens.stream().anyMatch(token1 -> token.equals(token1.getToken()));
    }

    public Token findByToken(String token) {
        return tokens.stream().filter(token1 -> token1.getToken().equals(token)).findFirst().get();
    }

    private String generateId(Entity entity) {
        String id = UUID.randomUUID().toString();
        switch (entity) {
            case USER : {
                if (users.stream().anyMatch(user -> user.getId().equals(id))) {
                    return generateId(entity);
                }
            } break;
            case TOKEN : {
                if (tokens.stream().anyMatch(token -> token.getId().equals(id))) {
                    return generateId(entity);
                }
            }
        }
        return id;
    }

    private enum Entity {
        USER, TOKEN
    }
}
