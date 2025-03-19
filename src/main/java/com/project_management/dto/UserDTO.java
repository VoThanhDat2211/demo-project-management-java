package com.project_management.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;

    @NotBlank(message = "Email is required")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    @Email(message = "Email is invalid")
    @Column(unique = true)
    private String email;


    @NotBlank(message = "Password is required")
    @Size(max = 255, message = "Password cannot exceed 255 characters")
    @Pattern(regexp = "^.{6,}$", message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Role is required")
    @Size(max = 20, message = "Role cannot exceed 20 characters")
    private String role;
}
