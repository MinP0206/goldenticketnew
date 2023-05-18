package com.example.goldenticketnew.payload;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GetAllUserRequest {
    @JsonIgnore
    private Pageable pageable;
    private String username;

    private String name;

    private String email;

    public Specification<User> getSpecification(){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (username != null) {
                predicates.add(cb.like(cb.lower(root.get(User.Fields.username)), "%" + username.toLowerCase() + "%"));
            }
            if (name != null) {
                predicates.add(cb.like(cb.lower(root.get(User.Fields.name)), "%" + name.toLowerCase() + "%"));
            }
            if(email != null){
                predicates.add(cb.like(cb.lower(root.get(User.Fields.email)), "%" + email.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
