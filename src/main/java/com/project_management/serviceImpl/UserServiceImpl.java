package com.project_management.serviceImpl;

import com.project_management.dto.UserDTO;
import com.project_management.entity.User;
import com.project_management.exception.BadRequestException;
import com.project_management.repository.UserRepository;
import com.project_management.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final ModelMapper mapper = new ModelMapper();
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, MessageSource messageSource) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) throws BadRequestException {
        boolean userExists = existsUserByEmail(userDTO.getEmail());
        if(userExists) {
            log.error("Email already in use");
            throw new BadRequestException("User already exists.");
        } else {
            User user = convertToUser(userDTO);
            userRepository.save(user);
        }
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }

    private UserDTO convertToUserDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    private  User convertToUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }
}
