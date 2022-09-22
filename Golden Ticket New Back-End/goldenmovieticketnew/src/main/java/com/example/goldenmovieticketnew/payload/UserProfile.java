package com.example.goldenmovieticketnew.payload;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class UserProfile {
    private String id;
    private String email;
    private String fullname;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
}
