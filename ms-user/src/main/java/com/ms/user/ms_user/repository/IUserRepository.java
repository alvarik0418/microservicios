package com.ms.user.ms_user.repository;

import com.ms.user.ms_user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
