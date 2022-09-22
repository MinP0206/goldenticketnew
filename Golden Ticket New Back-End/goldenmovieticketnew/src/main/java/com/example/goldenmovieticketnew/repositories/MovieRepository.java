package com.example.goldenmovieticketnew.repositories;


import com.example.goldenmovieticketnew.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findMoviesByIsShowingOrderByIdDesc(Integer isShowing);
    List<Movie> findMoviesByIsShowingAndNameContaining(Integer isShowing,String name);
}
