package com.amit.sahay.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.sahay.ems.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
   boolean existsByEmail(String email);
}
