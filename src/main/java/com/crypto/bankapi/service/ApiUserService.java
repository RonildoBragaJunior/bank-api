package com.crypto.bankapi.service;


import com.crypto.bankapi.entity.ApiRole;
import com.crypto.bankapi.entity.ApiUser;

import java.util.List;

public interface ApiUserService {
    ApiUser saveUser(ApiUser apiUser);
    ApiRole saveRole(ApiRole apiRole);
    void addRoleToUser(String username, String roleName);
    ApiUser getUser(String username);
    List<ApiUser>getUsers();
}