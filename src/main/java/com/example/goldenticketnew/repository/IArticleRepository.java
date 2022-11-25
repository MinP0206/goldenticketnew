package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IArticleRepository extends JpaRepository<Article,Long> , JpaSpecificationExecutor<Article> {
}
