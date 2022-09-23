package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "roles")
public class Role {

    @Id
    private String id;
    @Indexed(unique = true)
    private RoleName role;

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
