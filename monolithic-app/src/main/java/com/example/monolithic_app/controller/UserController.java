package com.example.monolithic_app.controller;

import com.example.monolithic_app.model.user;
import com.example.monolithic_app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userService userService;

    @GetMapping
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<user> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public user createUser(@RequestBody user user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PutMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
