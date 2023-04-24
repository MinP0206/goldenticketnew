package com.example.goldenticketnew.repository;


import com.example.goldenticketnew.model.Like;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ILikeRepository extends JpaRepository<Like,Long>, JpaSpecificationExecutor<Like> {
    Like findFirstByUserIdAndArticleId(Long userId, Long articleId);
    List<Like> findAllByArticleId(Long articleId, Sort sort);
}
