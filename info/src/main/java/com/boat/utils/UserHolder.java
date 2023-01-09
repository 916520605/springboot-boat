package com.boat.utils;

import com.boat.entity.User;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/1/4 21:22
 */
public class UserHolder {
    private static final ThreadLocal<User> TL = new ThreadLocal<>();

    public static void saveUser(User userId) {
        TL.set(userId);
    }

    public static User getUser() {
        return TL.get();
    }

    public static void removeUser() {
        TL.remove();
    }
}
