package com.tennisrank.dao;

import com.tennisrank.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private final static Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("rafael@me.com.br", new User("rafael@me.com.br", "rafael"));
    }

    public User findByEmailAndPassword(String email, String password) {
        if (!USERS.containsKey(email)) {
            return null;
        }

        User user = USERS.get(email);

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
