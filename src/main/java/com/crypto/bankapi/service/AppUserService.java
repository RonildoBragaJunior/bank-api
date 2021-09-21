package com.crypto.bankapi.service;

import com.crypto.bankapi.entity.AppUserEntity;
import com.crypto.bankapi.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUserEntity> getAllUsers(){
        return appUserRepository.findAll();
    }
}
