package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends DateAudit {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String image;
    private Set<Role> roles;
}
