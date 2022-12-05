package com.example.goldenticketnew.dtos;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.model.audit.DateAudit;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends DateAudit {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String image;
    private String role;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getName();
        this.image = user.getImage();
        this.role = user.getRoles().stream().findFirst().get().getName().toString();
    }

}
