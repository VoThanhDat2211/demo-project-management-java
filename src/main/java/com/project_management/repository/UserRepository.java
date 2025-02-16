package com.project_management.repository;

import com.project_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     boolean  existsUserByEmail(String email);

     Optional<User> findByEmail(String email);
}
