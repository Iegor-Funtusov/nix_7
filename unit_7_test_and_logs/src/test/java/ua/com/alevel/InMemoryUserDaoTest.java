package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.com.alevel.dao.InMemoryUserDao;
import ua.com.alevel.entity.User;

import java.util.List;

public class InMemoryUserDaoTest {

    private final InMemoryUserDao userDao = new InMemoryUserDao();

    @Test
    public void create() {
        List<User> users = userDao.findAllUsers();
        Assertions.assertEquals(0, users.size());
        User user = UserGenerationUtil.generateUser();
        userDao.create(user);
        users = userDao.findAllUsers();
        Assertions.assertEquals(1, users.size());
        Assertions.assertNotNull(users.get(0).getId());
    }
}
