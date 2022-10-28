package com.capgemini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> {
            try {
                auth
                        .antMatchers("/").hasAnyRole("ADMIN", "MANAGER")
                        .antMatchers("/login").permitAll()
                        .antMatchers("/admin/**").hasAnyRole("ADMIN")
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                        .permitAll()
                        .and()
                        .logout()
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                        .and()
                        .csrf()
                        .disable();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }

    @Bean
    protected InMemoryUserDetailsManager configAuthentication() {

        List<UserDetails> users = new ArrayList<>();
        List<GrantedAuthority> adminAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails admin = new User("admin", "admin", adminAuthority);
        users.add(admin);


        List<GrantedAuthority> managerAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
        UserDetails manager = new User("manager", "manager", managerAuthority);
        users.add(manager);

        return new InMemoryUserDetailsManager(users);
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**");
    }

}
