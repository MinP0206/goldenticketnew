package com.example.goldenticketnew.repository;

import com.example.goldenticketnew.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentRepository extends JpaRepository<Content,Long> {

}
