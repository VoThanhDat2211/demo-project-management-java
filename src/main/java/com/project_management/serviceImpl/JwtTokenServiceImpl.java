package com.project_management.serviceImpl;

import com.project_management.service.JwtTokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    public static final long JWT_EXPIRATION = 300000;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public String createToken(String email) {
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWT_EXPIRATION);
        SecretKey key = this.getSecretKey(jwtSecret);

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key)
                .compact();
    }

    @Override
    public String getEmailFromJWT(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getSecretKey(jwtSecret))
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            SecretKey key = this.getSecretKey(jwtSecret);
            Jwts.parser().decryptWith(key).build().parse(token);
            return true;
        } catch(SecurityException | MalformedJwtException e) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        } catch (ExpiredJwtException e) {
            throw new AuthenticationCredentialsNotFoundException("Expired JWT token.");
        } catch (UnsupportedJwtException e) {
            throw new AuthenticationCredentialsNotFoundException("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            throw new AuthenticationCredentialsNotFoundException("JWT token compact of handler are invalid.");
        }
    }

    private SecretKey getSecretKey(String secretKey) {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
