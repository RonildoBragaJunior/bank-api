package com.crypto.bankapi.service;

import com.crypto.bankapi.entity.ApiUser;
import com.crypto.bankapi.entity.ApiRole;
import com.crypto.bankapi.repository.ApiRoleRepository;
import com.crypto.bankapi.repository.ApiUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ApiUserServiceImpl implements ApiUserService, UserDetailsService {
    private final ApiUserRepository userRepo;
    private final ApiRoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUser apiUser = userRepo.findByUsername(username);
        if(apiUser == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            apiUser.getApiRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(apiUser.getUsername(), apiUser.getPassword(), authorities);
        }
    }

    @Override
    public ApiUser saveUser(ApiUser apiUser) {
        log.info("Saving new user {} to the database", apiUser.getName());
        apiUser.setPassword(passwordEncoder.encode(apiUser.getPassword()));
        return userRepo.save(apiUser);
    }

    @Override
    public ApiRole saveRole(ApiRole apiRole) {
        log.info("Saving new role {} to the database", apiRole.getName());
        return roleRepo.save(apiRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        ApiUser apiUser = userRepo.findByUsername(username);
        ApiRole apiRole = roleRepo.findByName(roleName);
        apiUser.getApiRoles().add(apiRole);
    }

    @Override
    public ApiUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<ApiUser> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}