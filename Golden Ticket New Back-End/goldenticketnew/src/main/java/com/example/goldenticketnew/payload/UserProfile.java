package com.example.goldenticketnew.payload;

import com.example.goldenticketnew.model.audit.DateAudit;

import java.time.Instant;

public class UserProfile extends DateAudit {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String image;

    public UserProfile(Long id, String username, String email, String name, String image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
