package ua.com.alevel;

import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

public class TestAndLogsMain {

    public static void main(String[] args) {
        System.out.println("TestAndLogsMain.main");
        User user = new User();
        user.setName("test");
        user.setAge(10);
        UserService userService = new UserService();
        userService.create(user);
    }
}
