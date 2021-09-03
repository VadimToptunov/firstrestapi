package com.vadimtoptunov.firstrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.vadimtoptunov.firstrestapi.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
}
