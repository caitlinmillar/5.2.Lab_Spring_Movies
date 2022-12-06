package com.example52.Lab_Movie.repositories;

import com.example52.Lab_Movie.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MovieList {

    private List<String> movies;

    public MovieList(){
        this.movies = Arrays.asList(
                "Back to the future",
                "Austin Powers",
                "Batman forever",
                "Back to the future 2",
                "Beetlejuice",
                "Les Miserables",
                "Our silent voice",
                "Spirited Away",
                "High School Musical"
        );
    }

    public String getMovieById(int id){
        return this.movies.get(id -1);
    }

 //   public void addMovie(Movie movie){this.movies.add(movie);}


}
