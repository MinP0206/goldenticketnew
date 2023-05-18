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
public class GetAllCateRequest {
    @JsonIgnore
    private Pageable pageable;

    private String name;


    public Specification<Category> getSpecification(){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(cb.like(cb.lower(root.get(User.Fields.name)), "%" + name.toLowerCase() + "%"));
            }


            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
