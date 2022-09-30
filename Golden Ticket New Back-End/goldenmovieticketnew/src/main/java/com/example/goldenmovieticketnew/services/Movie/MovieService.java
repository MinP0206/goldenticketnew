package com.example.goldenmovieticketnew.services.Movie;

import com.example.goldenmovieticketnew.dtos.MovieDto;
import com.example.goldenmovieticketnew.models.Movie;
import com.example.goldenmovieticketnew.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MovieDto> findAllShowingMovies() {
        List<Movie> movies= movieRepository.findMoviesByIsShowingOrderByIdDesc(1);
        MovieDto moviesdto = new MovieDto();
                moviesdto.setId("aa");

                moviesdto= modelMapper.map(movies.get(0), MovieDto.class);

        return movieRepository.findMoviesByIsShowingOrderByIdDesc(1)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getById(String movieId) {
        return modelMapper.map(movieRepository.findById(movieId),MovieDto.class);
    }

    @Override
    public List<MovieDto> findAllShowingMoviesByName(String keyword) {
        return movieRepository.findMoviesByIsShowingAndNameContaining(1,keyword)
                .stream().map(movie -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }
}
