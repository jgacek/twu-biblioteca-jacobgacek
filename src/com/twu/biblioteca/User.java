package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<LibraryBook> myBooks;
    private ArrayList<Movie> myMovies;

    public User(String name) {
        this.name = name;
        this.myBooks = new ArrayList<LibraryBook>();
        this.myMovies = new ArrayList<Movie>();
    }

    public void addItemToMyList(Media media) {
        if (media instanceof LibraryBook) {
            addBookToMyBooks((LibraryBook) media);
        } else {
            addMovieToMyMovies((Movie) media);
        }
    }

    private void addBookToMyBooks(LibraryBook book) {
        this.myBooks.add(book);
    }

    private void addMovieToMyMovies(Movie movie) {
        this.myMovies.add(movie);
    }

    public void returnItemFromList(Media media) {
        if (media instanceof LibraryBook) {
            returnBookFromMyBooks((LibraryBook) media);
        } else {
            returnMovieFromMyMovies((Movie) media);
        }
    }

    private void returnMovieFromMyMovies(Movie movie) {
        Movie[] allMyMovies = myMovies.toArray(new Movie[0]);
        for (Movie m : allMyMovies) {
            if (m.getTitle().equals(movie.getTitle())) {
                this.myMovies.remove(m);
            }
        }
    }

    private void returnBookFromMyBooks(LibraryBook book) {
        LibraryBook[] allMyBooks = myBooks.toArray(new LibraryBook[0]);
        for (LibraryBook b : allMyBooks) {
            if (b.getTitle().equals(book.getTitle())) {
                this.myBooks.remove(b);
            }
        }
    }

    public String myItems() {
        String listOfItems = "";
        for (Media book : myBooks) {
            listOfItems = listOfItems + book.printInfo();
        }
        for (Media movie : myMovies) {
            listOfItems = listOfItems + movie.printInfo();
        }
        if (listOfItems.equals("")) {
            listOfItems = "You currently have no books checkout out\n";
        }
        return listOfItems;
    }
}
