package com.capgemini.services;

import com.capgemini.entities.Role;
import com.capgemini.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(UserEntity user);

    void save(Role role);

    List<UserEntity> getAllUsers();

    List<Role> getAllRoles();

    Role getRoleByName(String role);

    void cleanDataBase();
}
