package com.project_management.service;

import com.project_management.dto.UserDTO;
import com.project_management.dto.UserRecord;
import com.project_management.exception.BadRequestException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
     void createUser(UserDTO userDTO) throws BadRequestException;

     boolean existsUserByEmail(String email);

     List<UserRecord> getAll();
}
