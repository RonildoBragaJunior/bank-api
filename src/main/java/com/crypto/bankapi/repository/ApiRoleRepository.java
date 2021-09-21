package com.crypto.bankapi.repository;


import com.crypto.bankapi.entity.ApiRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApiRoleRepository extends JpaRepository<ApiRole, Long> {
    ApiRole findByName(String name);
}
