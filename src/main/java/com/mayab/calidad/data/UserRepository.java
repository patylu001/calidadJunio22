package com.mayab.calidad.data;

import java.util.HashMap;
import java.util.Map;

import com.mayab.calidad.entities.User;

public class UserRepository {

    private Map<String, User> users = new HashMap<String, User>();

    public UserRepository() {
        users.put("matt", new User("matt", "letmein"));
        users.put("frank", new User("frank", "myPassword"));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
