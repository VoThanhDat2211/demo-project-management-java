//package com.project_management.controller;
//
//import com.project_management.dto.LoginDTO;
//import com.project_management.dto.ResponseDTO;
//import com.project_management.service.JwtTokenService;
//import com.project_management.serviceImpl.UserServiceImpl;
//import jakarta.validation.Valid;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
//    private final JwtTokenService jwtTokenService;
//    private final AuthenticationManager authenticationManager;
//    public LoginController(JwtTokenService jwtTokenService,
//        AuthenticationManager authenticationManager) {
//        this.jwtTokenService = jwtTokenService;
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("")
//    public ResponseDTO<String> login(@RequestBody @Valid LoginDTO loginDTO) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDTO.getEmail(), loginDTO.getPassword()));
//        System.out.println("\u001B[31m" + "authenticate " + "\u001B[0m");
//        String token = this.jwtTokenService.createToken(loginDTO.getEmail());
//
//        return ResponseDTO.<String>builder()
//                .code(HttpStatus.OK.value())
//                .data(token)
//                .message("Login Successful")
//                .build();
//    }
//}
