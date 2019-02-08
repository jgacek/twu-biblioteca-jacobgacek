package com.twu.biblioteca;

public class LibraryBook {
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public LibraryBook(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.yearPublished = year;
        this.checkedOut = false;
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

    public boolean isCheckedOut(){
        return this.checkedOut;
    }
}
