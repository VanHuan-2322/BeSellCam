package com.example.shopcamera.Controller;

import com.example.shopcamera.Model.User;
import com.example.shopcamera.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> login(@RequestBody User user) {
        User user1 = userService.checkAccount(user);
        if (user1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
