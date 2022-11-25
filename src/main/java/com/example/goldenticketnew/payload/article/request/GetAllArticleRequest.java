package com.example.goldenticketnew.payload.article.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
public class GetAllArticleRequest {
    @JsonIgnore
    Pageable pageable;
}
