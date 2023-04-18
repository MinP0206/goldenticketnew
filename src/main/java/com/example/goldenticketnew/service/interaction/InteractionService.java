package com.example.goldenticketnew.service.interaction;

import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.model.Comment;
import com.example.goldenticketnew.model.Like;
import com.example.goldenticketnew.repository.ICommentRepository;
import com.example.goldenticketnew.repository.ILikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class InteractionService implements IInteractionService{

    private final ILikeRepository likeRepository;
    private final ICommentRepository commentRepository;


    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public List<Like> getAllLike() {
        return likeRepository.findAll();
    }

    @Override
    public Comment addNewComment() {
        return null;
    }

    @Override
    public Like addNewLike() {
        return null;
    }
}
