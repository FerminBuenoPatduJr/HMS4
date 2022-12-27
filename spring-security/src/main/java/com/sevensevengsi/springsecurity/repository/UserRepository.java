package com.sevensevengsi.springsecurity.repository;

import com.sevensevengsi.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, Integer>{
    public User findByUsername(String username);
}
