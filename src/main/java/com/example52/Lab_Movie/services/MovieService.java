package com.example52.Lab_Movie.services;

import com.example52.Lab_Movie.controllers.MovieController;
import com.example52.Lab_Movie.models.Movie;
import com.example52.Lab_Movie.models.Reply;
import com.example52.Lab_Movie.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    IMovieRepository iMovieRepository;

    @Autowired
    MovieService movieService;

    private String currentMovie;
    private ArrayList<Integer> allRatings;
    private ArrayList<String> allMovies;

    //empty constructor
    public MovieService(){}

    public String getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(String currentMovie) {
        this.currentMovie = currentMovie;
    }

    public ArrayList<Integer> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(ArrayList<Integer> allRatings) {
        this.allRatings = allRatings;
    }


    public Reply processMovie(int id){
        Movie movie = iMovieRepository.findById(id).get();

        return new Reply("Back to the future");
    }



    public Reply startMovie(){
        String currentMovie = movieService.getCurrentMovie();
        Movie movie = new Movie(currentMovie);
        iMovieRepository.save(movie);
        return new Reply(
                String.format("New movies with id %d", movie.getId())
        );
    }

    public List<Movie> getAllMovies(){return iMovieRepository.findAll();}
    public Optional<Movie> getMovieById(int id){return iMovieRepository.findById(id);}

}
