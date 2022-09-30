package com.example.goldenmovieticketnew.services.Movie;

import com.example.goldenmovieticketnew.dtos.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findAllShowingMovies();
    MovieDto getById(String movieId);
    List<MovieDto> findAllShowingMoviesByName(String name);

}
