package com.example.goldenticketnew.dtos;


import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.model.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


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

    private String bio;

    private Integer followers;

    private List<CategoryDto> categories;

    private boolean isNew = true;

    private boolean isContentCreator;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getName();
        if(user.getIsContentCreator()!=null){
            if(user.getIsContentCreator()==0){
                this.isContentCreator = false;
            }else {
                this.isContentCreator = true;
            }
        }
        if(user.getImage() != null)  this.image = user.getImage();
        this.role = user.getRoles().stream().findFirst().get().getName().toString();
        if(user.getBio() !=null)  this.bio = user.getBio();
        if(user.getFollowers() != null)  this.followers = user.getFollowers();
        if(user.getCategories()!=null)  {
            this.categories = user.getCategories().stream().map(CategoryDto::new).collect(Collectors.toList());
            this.isNew = false;
        }
        }

}
