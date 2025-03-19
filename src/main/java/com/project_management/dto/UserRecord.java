package com.project_management.dto;

import com.project_management.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class UserRecord {
    private static final Logger logger = LoggerFactory.getLogger(UserRecord.class);

    private int id;
    private String email;
    private String password;
    private String role;
    private String abc;

    public UserRecord(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        logger.info("Constructor 3 tham số được gọi!");
    }

}
