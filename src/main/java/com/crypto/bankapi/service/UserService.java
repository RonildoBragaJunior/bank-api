package com.crypto.bankapi.service;


import com.crypto.bankapi.entity.Role;
import com.crypto.bankapi.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}