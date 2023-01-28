package com.projects.springdatajpapostgresql.api;

import com.projects.springdatajpapostgresql.dto.UserDto;
import com.projects.springdatajpapostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.save(userDto),HttpStatus.CREATED);
    }
}
