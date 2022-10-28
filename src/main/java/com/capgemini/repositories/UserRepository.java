package com.capgemini.repositories;

import com.capgemini.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String Username);

    Boolean existsByUsername(String Username);

}
