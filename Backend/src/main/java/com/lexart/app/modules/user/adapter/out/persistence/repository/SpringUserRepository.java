package com.lexart.app.modules.user.adapter.out.persistence.repository;

import com.lexart.app.modules.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}