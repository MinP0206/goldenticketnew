package com.example.goldenticketnew.model;


import com.example.goldenticketnew.model.audit.DateAudit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
//@(name = "users", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//            "username"
//        }),
//        @UniqueConstraint(columnNames = {
//            "email"
//        })
//})
public class User extends DateAudit {
    @Id
    private Long id;


    private String name;

    @Indexed(unique = true)
    private String username;


    @Indexed(unique = true)
    private String email;


    private String image;


    private String password;




    private Set<Role> roles = new HashSet<>();


    public User() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}