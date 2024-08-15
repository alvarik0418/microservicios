package com.ms.user.ms_user.controller;

import com.ms.user.ms_user.dto.UserDTO;
import com.ms.user.ms_user.model.UserEntity;
import com.ms.user.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController implements IUserDoc{

    private final IUserService userService;

    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PutMapping()
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserDTO user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
