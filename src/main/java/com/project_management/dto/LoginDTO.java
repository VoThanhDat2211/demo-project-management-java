package com.project_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull(message = "Email is required")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotNull(message = "Password is required")
    @Size(max = 255, message = "Password cannot exceed 255 characters")
    private String password;
}
