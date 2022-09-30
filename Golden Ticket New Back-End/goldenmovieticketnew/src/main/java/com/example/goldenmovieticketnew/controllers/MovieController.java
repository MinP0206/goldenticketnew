package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.dtos.MovieDto;
import com.example.goldenmovieticketnew.models.Movie;
import com.example.goldenmovieticketnew.repositories.MovieRepository;
import com.example.goldenmovieticketnew.services.Movie.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/movies", produces = "application/json")
@Api(value = "Movie APIs")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;
    @ApiOperation(value = "Show tất cả phim", response = List.class)
    @GetMapping("/showing")
    public ResponseEntity<List<MovieDto>> findAllShowingMovies(){
        return new ResponseEntity<>(movieService.findAllShowingMovies(), HttpStatus.OK);
    }
    @ApiOperation(value = "Xem chi tiet phim by id")
    @GetMapping("/details")
    public MovieDto getMovieById(@RequestParam String movieId){
        return movieService.getById(movieId);
    }

    @ApiOperation(value = "Tìm kiếm danh sách phim by name", response = List.class)
    @GetMapping("/showing/search")
    public List<MovieDto> findAllShowingMoviesByName(@RequestParam String name){
        return movieService.findAllShowingMoviesByName(name);
    }

    @PostMapping
    public void updateMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
    }
}
