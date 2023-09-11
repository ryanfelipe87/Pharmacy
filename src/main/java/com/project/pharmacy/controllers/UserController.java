package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.UserDto;
import com.project.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        userService.create(userDto);
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }
}
