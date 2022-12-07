package com.example52.Lab_Movie.services;

import com.example52.Lab_Movie.models.Movie;
import com.example52.Lab_Movie.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    IMovieRepository iMovieRepository;

    private String currentMovie;
    //empty constructor
    public MovieService(){}

    public void addMovie(String title, int rating, int duration) {
        Movie movie = new Movie(title, rating, duration);
        iMovieRepository.save(movie);
    }

    public void updateMovieById(int id, String title, int rating, int duration){

        Movie movie = iMovieRepository.findById(id).get();

        movie.setTitle(title);
        movie.setRating(rating);
        movie.setDuration(duration);

        iMovieRepository.save(movie);
    }

    public void deleteMovieById(int id){
        iMovieRepository.deleteById(id);
    }

    public String getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(String currentMovie) {
        this.currentMovie = currentMovie;
    }



    public List<Movie> getAllMovies(){
        return iMovieRepository.findAll();}

    public Optional<Movie> getMovieById(int id){
        return iMovieRepository.findById(id);}

}
