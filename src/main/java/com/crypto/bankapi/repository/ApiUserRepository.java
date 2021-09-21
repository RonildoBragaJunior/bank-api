package com.crypto.bankapi.repository;

import com.crypto.bankapi.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
    ApiUser findByUsername(String username);
}