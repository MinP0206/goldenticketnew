package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IArticleRepository extends JpaRepository<Article,Long> , JpaSpecificationExecutor<Article> {
    @Query(value = " Select count(id) from article  where year(created_at) = ?1 and month(created_at) = ?2",nativeQuery = true)
    Long getTotalArticle(int year,int month);
}
