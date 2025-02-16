package com.project_management.service;

import com.project_management.dto.LoginDTO;

public interface JwtTokenService {
    public String createToken(String username);
    public String getEmailFromJWT(String token);
    public boolean validateToken(String token);
}
