package ua.com.alevel.set;

import ua.com.alevel.data.User;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public void banch() {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "test"));
        users.add(new User(2, "test"));
        users.add(new User(3, "test"));
        users.add(new User(4, "test"));
        users.forEach(System.out::println);

        System.out.println();

        users = new LinkedHashSet<>();
        users.add(new User(4, "test"));
        users.add(new User(1, "test"));
        users.add(new User(2, "test"));
        users.add(new User(3, "test"));
        users.forEach(System.out::println);

        System.out.println();
        users = new TreeSet<>();
        users.add(new User(3, "test"));
        users.add(new User(1, "test"));
        users.add(new User(2, "test"));
        users.add(new User(3, "test"));
        users.forEach(System.out::println);
    }
}
