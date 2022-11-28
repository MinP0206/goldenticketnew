package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContentRepository extends JpaRepository<Content,Long> {
    @Modifying
    @Query(value = " DELETE FROM Content C WHERE C.article.id= :articleId")
    void deleteAllByArticleId(@Param("articleId") Long articleId);
}
