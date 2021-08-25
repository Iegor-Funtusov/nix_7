package ua.com.alevel;

import ua.com.alevel.data.User;
import ua.com.alevel.data.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Refer {

    public void test() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "user1"));
        users.add(new User(2, "user2"));
        users.add(new User(3, "user3"));
        users.add(new User(4, "user4"));
        users.add(new User(13, "user13"));

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDto(user));
        }

        userDtos = users.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
        userDtos = users.stream().map(UserDto::new).collect(Collectors.toList());

//        userDtos.forEach(System.out::println);

//        userDtos = users.stream()
//                .filter(this::isNot13Id)
//                .map(UserDto::new)
//                .collect(Collectors.toList());
//
//        System.out.println();
//        userDtos.forEach(System.out::println);

        userDtos = users.stream()
                .filter(NotLikeUtils::isNot13Id)
                .map(UserDto::new)
                .collect(Collectors.toList());

        System.out.println();
        userDtos.forEach(System.out::println);

    }

    private boolean isNot13Id(User user) {
        return user.getId() != 13;
    }
}
