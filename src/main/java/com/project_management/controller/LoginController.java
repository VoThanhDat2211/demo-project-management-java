package com.project_management.controller;

import com.project_management.dto.LoginDTO;
import com.project_management.dto.ResponseDTO;
import com.project_management.service.JwtTokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final JwtTokenService jwtTokenService;
    public LoginController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("")
    public ResponseDTO<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        String token = this.jwtTokenService.createToken(loginDTO.getEmail());

        return ResponseDTO.<String>builder()
                .code(HttpStatus.OK.value())
                .data(token)
                .message("Success")
                .build();
    }
}
