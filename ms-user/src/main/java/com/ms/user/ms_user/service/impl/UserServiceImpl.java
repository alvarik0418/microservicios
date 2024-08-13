package com.ms.user.ms_user.service.impl;

import com.ms.user.ms_user.model.UserEntity;
import com.ms.user.ms_user.repository.IUserRepository;
import com.ms.user.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository IUserRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserEntity user) {

        try {
            var newUser = this.IUserRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }
}
