package com.ms.user.ms_user.service.impl;

import com.ms.user.ms_user.dto.UserDTO;
import com.ms.user.ms_user.exception.MyHandleException;
import com.ms.user.ms_user.model.UserEntity;
import com.ms.user.ms_user.repository.IUserRepository;
import com.ms.user.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository IUserRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserDTO userDto) {
        var userCurrently = this.IUserRepository
                                .findByDocumentAndTypeDocument(userDto.getDocument(), userDto.getTypeDocument());

        if(userCurrently.isPresent()) {
            throw  new MyHandleException("El usuario ya existe en la base de datos");
        }

        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .document(userDto.getDocument())
                .typeDocument(userDto.getTypeDocument())
                .name(userDto.getUsername())
                .build();

        var newUser = this.IUserRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Override
    public ResponseEntity<UserEntity> getUser(String id) {
        try {
            if(!id.isEmpty()) {
                var user = this.IUserRepository.findById(id).orElseThrow(() -> new MyHandleException("El nuevo usuario no existe"));
                return ResponseEntity.status(HttpStatus.OK).body(user);
            }
            else {
                return ResponseEntity.badRequest().body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @Override
    public ResponseEntity<UserEntity> updateUser(UserDTO userDto) {
        UserEntity user = UserEntity.builder()
                .document(userDto.getDocument())
                .typeDocument(userDto.getTypeDocument())
                .name(userDto.getUsername())
                .build();

        if(!user.getId().isEmpty()) {
            return this.IUserRepository.findById(user.getId()).map
                    (
                            userLoad -> {
                                userLoad.setName(user.getName());
                                userLoad.setDocument(user.getDocument());
                                userLoad.setTypeDocument(user.getTypeDocument());
                                this.IUserRepository.save(userLoad);
                                return ResponseEntity.status(HttpStatus.OK).body(userLoad);
                            }
                    ).orElse(null);
        }else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String id) {
        try {
            if(!id.isEmpty()) {
                this.IUserRepository.findById(id).ifPresent(this.IUserRepository::delete);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
            }else {
                return ResponseEntity.badRequest().body(false);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
