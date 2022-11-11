package com.example.goldenticketnew.service.movie;

import com.example.goldenticketnew.dtos.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findAllShowingMovies();
    MovieDto getById(Integer movieId);
    List<MovieDto> findAllShowingMoviesByName(String name);
}
