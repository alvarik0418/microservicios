package com.ms.user.ms_user.controller;

import com.ms.user.ms_user.model.UserEntity;
import com.ms.user.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController implements IUserDoc{

    private final IUserService userService;

    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return userService.create(user);
    }

}
