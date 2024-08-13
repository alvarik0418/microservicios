package com.ms.user.ms_user.service;

import com.ms.user.ms_user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<UserEntity> create(UserEntity user);
}
