package com.crypto.bankapi.repository;

import com.crypto.bankapi.entity.AppUserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUserEntity, Long> {

    List<AppUserEntity> findAll();
}
