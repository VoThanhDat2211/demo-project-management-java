package com.project_management.service;

import com.project_management.dto.UserDTO;
import com.project_management.exception.BadRequestException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public void createUser(UserDTO userDTO) throws BadRequestException;

    public boolean existsUserByEmail(String email);

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
