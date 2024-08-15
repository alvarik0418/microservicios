package com.ms.user.ms_user.repository;

import com.ms.user.ms_user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByDocumentAndTypeDocument(String document, String typeDocument);
}
