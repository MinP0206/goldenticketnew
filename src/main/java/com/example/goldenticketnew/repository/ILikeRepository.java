package com.example.goldenticketnew.repository;


import com.example.goldenticketnew.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ILikeRepository extends JpaRepository<Like,Long>, JpaSpecificationExecutor<Like> {
}
