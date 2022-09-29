package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Set;
@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;


    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String email;
    @Indexed(unique = true)
    private String username;
    private String image;
    private String password;
    private String fullname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private boolean enabled;
    @DBRef
    private Set<Role> roles;

    public User(String email, String username, String image, String password, String fullname) {
        this.email = email;
        this.username = username;
        this.image = image;
        this.password = password;
        this.fullname = fullname;
    }
}
