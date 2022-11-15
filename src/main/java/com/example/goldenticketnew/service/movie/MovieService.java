package com.example.goldenticketnew.service.movie;


import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.model.Movie;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;
import com.example.goldenticketnew.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MovieDto addNewMovie(Movie movie) {
        Movie movieNew = movieRepository.save(movie);
        return modelMapper.map(movieNew,MovieDto.class);
    }

    @Override
    public MovieDto updateMovie(Movie movie) {
        if(movieRepository.getById(movie.getId()) != null) {
            Movie movieNew = movieRepository.save(movie);
            return modelMapper.map(movieNew, MovieDto.class);
        }
        else return new MovieDto();
    }

    @Override
    public List<MovieDto> findAllShowingMovies() {
        return movieRepository.findMoviesByIsShowingOrderByIdDesc(1)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getById(Integer movieId) {
        return modelMapper.map(movieRepository.getById(movieId), MovieDto.class);
    }

    @Override
    public List<MovieDto> findAllShowingMoviesByName(String keyword) {
        return movieRepository.findMoviesByIsShowingAndNameContaining(1,keyword)
                .stream().map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteMovieById(Integer movieId) {
        try{
            movieRepository.deleteById(movieId);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public PageResponse<MovieDto> getAllMovie(GetAllMovieRequest request) {
        Page<Movie> moviePage = movieRepository.findAll(request.getSpecification(),request.getPageable());
        return new PageResponse<>(moviePage.map(MovieDto::new));
    }
}
