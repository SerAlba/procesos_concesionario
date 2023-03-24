package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getById (@PathVariable(name = "id") Long id) {
        Map response = new HashMap();

        try {
            response.put("message", "User found");
            response.put("data", userServiceImp.getUserById(id));

            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e){
            response.put("message", "User not found");
            response.put("data", e.getMessage());

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user")
    public ResponseEntity createUser (@RequestBody User user) {
        Map response = new HashMap();

        try {
            response.put("message", "User created");
            response.put("data", userServiceImp.createUser(user));

            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e){
            response.put("message", "Error creating user");
            response.put("data", e.getMessage());

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/listUsers")
    public ResponseEntity getListUsers () {
        Map response = new HashMap();

        try {
            response.put("message", "Users found");
            response.put("data", userServiceImp.allUsers());

            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e){
            response.put("message", "There are no users");
            response.put("data", e.getMessage());

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity updateUser (@PathVariable(name = "id") Long id, @RequestBody User user) {
        Map response = new HashMap();

        try {
            response.put("message", "Updated user");
            response.put("data", userServiceImp.updateUser(id, user));

            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e){
            response.put("message", "Error updating user");
            response.put("data", e.getMessage());

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}