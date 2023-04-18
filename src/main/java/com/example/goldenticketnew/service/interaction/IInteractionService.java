package com.example.goldenticketnew.service.interaction;

import com.example.goldenticketnew.model.Comment;
import com.example.goldenticketnew.model.Like;


import java.util.List;


public interface IInteractionService {
    List<Comment> getAllComment() ;
    List<Like> getAllLike() ;

    Comment addNewComment();

    Like addNewLike();
}
