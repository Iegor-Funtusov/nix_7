package ua.com.alevel;

import ua.com.alevel.data.User;

public class NotLikeUtils {

    public static boolean isNot13Id(User user) {
        return user.getId() != 13;
    }
}
