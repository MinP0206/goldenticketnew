package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Like;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto extends Auditable{
    private Long id;
    private Integer isLike;
    private String name;
    private Long articleId;
    public LikeDto(Like like){
        this.id = like.getId();
        this.isLike = like.getIsLike();
        this.name = like.getUser().getName();
    }
}
