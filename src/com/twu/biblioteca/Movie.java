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

    @Override
    public String printInfo() {
        String info;
        info = String.format("%-22s%-22s%-22d%-22d\n",
                this.getTitle(),this.getAuthor(),this.getYear(),this.rating);
        return info;
    }

    @Override
    public String unavailable() {
        return "Sorry, that movie is unavailable";
    }

    @Override
    public String notValid() {
        return "That is not a valid movie to return";
    }
}
