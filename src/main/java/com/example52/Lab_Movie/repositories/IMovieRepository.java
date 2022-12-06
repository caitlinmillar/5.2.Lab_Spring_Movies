package com.example52.Lab_Movie.repositories;

import com.example52.Lab_Movie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
