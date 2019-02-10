package com.twu.biblioteca;

public class Movie extends Media {

    private int rating;

    public Movie(String title, String director, int year, int rating) {
        super(title,year,director);
        this.rating = rating;
    }

    public String getDirector() {
        return this.author;
    }

    public int getRating() {
        return this.rating;
    }
}
