package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity login (@RequestBody User user) {
        Map response = new HashMap();

        try {
            response.put("message", "User found");
            response.put("data", userService.login(user));

            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e){
            response.put("message", "Error login user");
            response.put("data", e.getMessage());

            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }
}
