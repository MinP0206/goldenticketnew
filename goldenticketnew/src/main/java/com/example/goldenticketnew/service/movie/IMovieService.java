package com.example.goldenticketnew.service.movie;

import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.model.Movie;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;

import java.util.List;

public interface IMovieService {
    MovieDto addNewMovie(Movie movie);
    MovieDto updateMovie(Movie movie);
    List<MovieDto> findAllShowingMovies();
    MovieDto getById(Integer movieId);
    List<MovieDto> findAllShowingMoviesByName(String name);
    Boolean deleteMovieById(Integer movieId);
    PageResponse<MovieDto> getAllMovie(GetAllMovieRequest request);


}
