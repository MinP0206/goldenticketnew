package com.example.goldenmovieticketnew.payload;

import lombok.Data;
import lombok.NoArgsConstructor;



public class SignUpRequest {

    private String fullname;


    private String image;


    private String email;


    private String password;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public SignUpRequest(String fullname, String image, String email, String password) {
        this.fullname = fullname;
        this.image = image;
        this.email = email;
        this.password = password;
    }
}
