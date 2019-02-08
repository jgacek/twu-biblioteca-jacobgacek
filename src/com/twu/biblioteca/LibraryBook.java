package com.twu.biblioteca;

public class LibraryBook {
    private String title;
    private String author;
    private int yearPublished;
    public boolean isCheckedOut;

    public LibraryBook(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.yearPublished = year;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

}
