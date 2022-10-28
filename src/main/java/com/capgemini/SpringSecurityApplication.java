package com.capgemini;

import com.capgemini.entities.Role;
import com.capgemini.entities.UserEntity;
import com.capgemini.repositories.RoleRepository;
import com.capgemini.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        List<Role> roleSet = new ArrayList<>();
        Role role = roleRepository.findByRoleName("ADMIN");
        roleSet.add(role);
        userRepository.save(new UserEntity(4L, "bouka", "bouka", roleSet));
    }

}
