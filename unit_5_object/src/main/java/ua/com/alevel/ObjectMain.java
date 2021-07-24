package ua.com.alevel;

import ua.com.alevel.domain.User;

public class ObjectMain {

    public static void main(String[] args) {
        final User user1 = new User();
        user1.setAge(67);
        System.out.println("user1 = " + user1);
        User user2 = user1;
        user2.setAge(78);
        System.out.println("user1 = " + user1);
    }
}
