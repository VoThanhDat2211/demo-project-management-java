package com.project_management.controller;

import com.project_management.dto.ResponseDTO;
import com.project_management.dto.UserDTO;
import com.project_management.dto.UserRecord;
import com.project_management.entity.User;
import com.project_management.exception.BadRequestException;
import com.project_management.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService  userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserRecord>> getAll(){
        List<UserRecord> list = userService.getAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseDTO<Void> createUser(@RequestBody @Valid UserDTO userDTO) throws BadRequestException {
//        int code = HttpStatus.OK.value();
//        String message = "create user successfully";
//
//        this.userService.createUser(userDTO);
//
//        return ResponseDTO.<Void>builder()
//                .code(code)
//                .message(message)
//                .build();
//    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) throws BadRequestException {
        int code = HttpStatus.OK.value();
        String message = "create user successfully";

        this.userService.createUser(userDTO);

        return ResponseEntity.ok(message);

    }

}
