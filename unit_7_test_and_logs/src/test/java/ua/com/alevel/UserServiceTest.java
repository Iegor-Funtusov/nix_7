package ua.com.alevel;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    private final static UserService userService = new UserService();
    private final static int USERS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < USERS_SIZE; i++) {
            User user = UserGenerationUtil.generateUser(UserGenerationUtil.NAME + i, i);
            userService.create(user);
        }
        Assertions.assertEquals(USERS_SIZE, userService.findAllUsers().size());
    }

    @Test
    @Order(2)
    public void createUserIfAgeNotValid() {
        User user = UserGenerationUtil.generateUser(100);
        userService.create(user);
        List<User> users = userService.findAllUsers();
        Assertions.assertNotEquals(USERS_SIZE + 1, users.size());
    }

    @Test
    @Order(3)
    public void createUserIfAgeValid() {
        User user = UserGenerationUtil.generateUser(87);
        userService.create(user);
        List<User> users = userService.findAllUsers();
        Assertions.assertEquals(USERS_SIZE + 1, users.size());
    }

    @Test
    @Order(4)
    public void update() {
        List<User> users = userService.findAllUsers();
        User user = users.get(0);
        userService.update(user);
    }

    @Test
    @Order(5)
    public void findAll() {
        List<User> users = userService.findAllUsers();
        Assertions.assertEquals(USERS_SIZE + 1, users.size());
    }

    @Test
    @Order(6)
    public void delete() {
        List<User> users = userService.findAllUsers();
        Assertions.assertEquals(USERS_SIZE + 1, users.size());
        User user = users.get(0);
        userService.delete(user.getId());
        users = userService.findAllUsers();
        Assertions.assertEquals(USERS_SIZE, users.size());
    }
}
