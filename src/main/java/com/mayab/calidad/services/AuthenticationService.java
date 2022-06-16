package com.mayab.calidad.services;

import com.mayab.calidad.data.UserRepository;
import com.mayab.calidad.entities.User;

public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user.getPassword().equals(password);
    }
}
