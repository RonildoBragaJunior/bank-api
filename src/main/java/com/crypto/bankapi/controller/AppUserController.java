package com.crypto.bankapi.controller;

import com.crypto.bankapi.entity.AppUserEntity;
import com.crypto.bankapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-management")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/users")
    public List<AppUserEntity> getUsers(){
        return appUserService.getAllUsers();
    }
}

