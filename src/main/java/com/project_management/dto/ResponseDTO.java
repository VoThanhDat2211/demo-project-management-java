package com.project_management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private int code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
