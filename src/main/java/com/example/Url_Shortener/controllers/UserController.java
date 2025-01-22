package com.example.Url_Shortener.controllers;

import com.example.Url_Shortener.dto.UserDto;
import com.example.Url_Shortener.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        if(user.isNull()){
            throw new RuntimeException("Provide the user details.");
        }

        UserDto response=userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long user_id){
        if(user_id== null ){
            throw new RuntimeException("Provide a user_id");
        }
       UserDto response= userService.getUser(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
