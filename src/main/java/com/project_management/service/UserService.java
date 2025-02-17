package com.project_management.service;

import com.project_management.dto.UserDTO;
import com.project_management.exception.BadRequestException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
     void createUser(UserDTO userDTO) throws BadRequestException;

     boolean existsUserByEmail(String email);
}
