package com.ms.user.ms_user.service;

import com.ms.user.ms_user.dto.UserDTO;
import com.ms.user.ms_user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    public ResponseEntity<UserEntity> create(UserDTO user);
    public ResponseEntity<UserEntity> getUser(String id);
    public ResponseEntity<UserEntity> updateUser(UserDTO user);
    public ResponseEntity<Boolean> deleteUser(String id);
}
