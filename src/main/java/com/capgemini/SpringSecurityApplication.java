package com.capgemini;

import com.capgemini.repositories.RoleRepository;
import com.capgemini.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public SpringSecurityApplication(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

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
        userRepository.save(new UserEntity("admin", passwordEncoder().encode("admin"), roleSet1));
        userRepository.save(new UserEntity("manager", passwordEncoder().encode("manager"), roleSet2));*/
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
