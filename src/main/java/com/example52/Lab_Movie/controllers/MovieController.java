package com.example52.Lab_Movie.controllers;


import com.example52.Lab_Movie.models.Movie;
import com.example52.Lab_Movie.models.Reply;
import com.example52.Lab_Movie.repositories.IMovieRepository;
import com.example52.Lab_Movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //processing movies
    @PostMapping
    public ResponseEntity<String> processMovie(
            @RequestParam(value = "title") String title){
        movieService.processMovie(title);
        Reply reply = movieService.startMovie();

    }

}
