package com.capgemini;

import com.capgemini.entities.Role;
import com.capgemini.entities.UserEntity;
import com.capgemini.repositories.RoleRepository;
import com.capgemini.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

       /* Role r1 = new Role("ADMIN");
        Role r2 = new Role("MANAGER");
        roleRepository.save(r1);
        roleRepository.save(r2);

        List<Role> roleSet1 = new ArrayList<>();
        List<Role> roleSet2 = new ArrayList<>();
        Role role_admin = roleRepository.findByRoleName("ADMIN");
        Role role_manager = roleRepository.findByRoleName("MANAGER");

        roleSet1.add(role_admin);
        roleSet1.add(role_manager);
        roleSet2.add(role_manager);
        userRepository.save(new UserEntity("bouka", passwordEncoder().encode("bouka"), roleSet1));
        userRepository.save(new UserEntity("driss", passwordEncoder().encode("driss"), roleSet2));*/
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
