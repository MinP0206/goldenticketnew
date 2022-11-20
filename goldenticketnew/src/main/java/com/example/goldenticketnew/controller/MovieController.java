package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.model.Movie;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;
import com.example.goldenticketnew.repository.IMovieRepository;
import com.example.goldenticketnew.service.movie.IMovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/movies", produces = "application/json")
@Tag(name = "Movie Controller", description = "Thao tác với movie")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/showing")
    public ResponseEntity<List<MovieDto>> findAllShowingMovies(){
        return new ResponseEntity<>(movieService.findAllShowingMovies(), HttpStatus.OK);
    }

    @GetMapping("/details/{movieId}")
    public MovieDto getMovieById(@PathVariable Integer movieId){
        return movieService.getById(movieId);
    }

    @GetMapping("/showing/search")
    public List<MovieDto> findAllShowingMoviesByName(@RequestParam String name){
        return movieService.findAllShowingMoviesByName(name);
    }

    @PutMapping("/update")
    public MovieDto updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }
    @PostMapping("/addNew")
    public MovieDto addNewMovie(@RequestBody Movie movie){
        return movieService.addNewMovie(movie);
    }

    @DeleteMapping("/{movieId}")
    public ApiResponse deleteMovie(@Valid @PathVariable Integer movieId) {
        if(movieService.deleteMovieById(movieId))
            return new ApiResponse(true, "Delete Movie Successfully");
        return new ApiResponse(false, "Please check the id");
    }
    @Operation(
        summary = "Get All Movie với filter ",
        description = "- Get All Movie với filter"
    )
    @GetMapping("/getAll")
    public ResponseEntity<PageResponse<MovieDto>> findAllShowingMovies(@ParameterObject Pageable pageable, @ParameterObject GetAllMovieRequest request){
        request.setPageable(pageable);
        return new ResponseEntity<>(movieService.getAllMovie(request), HttpStatus.OK);
    }
}
