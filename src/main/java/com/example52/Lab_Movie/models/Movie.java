package com.example52.Lab_Movie.models;
//A Movie model with the properties:
//        id
//        title
//        rating
//        duration

import javax.persistence.*;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private int rating;
    @Column(name = "duration")
    private int duration;

    public Movie(String title, int rating, int duration){
        this.title = title;
        this.duration = 0;
        this.rating = 0;
    }

    public Movie(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
