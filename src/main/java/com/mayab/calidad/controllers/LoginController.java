package com.mayab.calidad.controllers;

import com.mayab.calidad.services.AuthenticationService;

public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public String service(String username, String password) {
        return authenticationService.authenticate(username, password) ? "/home": "/login";
    }

}
