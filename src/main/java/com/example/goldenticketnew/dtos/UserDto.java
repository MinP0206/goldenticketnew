package com.example.goldenticketnew.dtos;


import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.model.audit.DateAudit;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.repository.IArticleRepository;
import com.example.goldenticketnew.service.article.ArticleService;
import com.example.goldenticketnew.utils.BeanUtils;
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
    private boolean isNew = true;

    private boolean isContentCreator;

    private Long amountArticle ;

    private String reason;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getName();
        if(user.getIsContentCreator()!=null){
            if(user.getIsContentCreator()==0){
                this.isContentCreator = false;
            }else if(user.getIsContentCreator()==1){
                this.isContentCreator = true;
            }else if(user.getIsContentCreator()==2) {
                if(user.getReason()!=null) this.reason = user.getReason();
            }
        }
        if(user.getImage() != null)  this.image = user.getImage();
        this.role = user.getRoles().stream().findFirst().get().getName().toString();
        if(user.getBio() !=null)  this.bio = user.getBio();
        if(user.getFollowers() != null)  this.followers = user.getFollowers();
//        IArticleRepository articleRepository = BeanUtils.getBean(IArticleRepository.class);
//        GetAllArticleRequest request = new GetAllArticleRequest();
//        request.setUsername(user.getUsername());
//        this.amountArticle = articleRepository.findAll(request.getSpecification()).size();
        }


}
