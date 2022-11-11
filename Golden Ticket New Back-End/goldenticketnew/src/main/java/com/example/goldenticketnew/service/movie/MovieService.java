package com.example.goldenticketnew.service.movie;


import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository IMovieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovieDto> findAllShowingMovies() {
        return IMovieRepository.findMoviesByIsShowingOrderByIdDesc(1)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getById(Integer movieId) {
        return modelMapper.map(IMovieRepository.getById(movieId), MovieDto.class);
    }

    @Override
    public List<MovieDto> findAllShowingMoviesByName(String keyword) {
        return IMovieRepository.findMoviesByIsShowingAndNameContaining(1,keyword)
                .stream().map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }
}
