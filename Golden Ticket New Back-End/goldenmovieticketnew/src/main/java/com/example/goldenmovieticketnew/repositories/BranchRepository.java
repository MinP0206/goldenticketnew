package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends MongoRepository<Branch, String> {
    @Query("{}")
    List<Branch> getBranchThatShowTheMovie(@Param("movieId") String movieId);
}
