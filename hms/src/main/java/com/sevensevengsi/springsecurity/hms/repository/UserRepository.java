package com.sevensevengsi.springsecurity.hms.repository;


import com.sevensevengsi.springsecurity.hms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, Integer>{
    public User findByUsername(String username);
}
