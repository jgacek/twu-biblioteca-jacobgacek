package com.twu.biblioteca;

public class LibraryBook extends Media {

    public LibraryBook(String title, String author, int year){
        super(title, year, author);
    }

    public String getAuthor() {
        return this.author;
    }

}
