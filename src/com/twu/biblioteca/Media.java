package com.twu.biblioteca;

public class Media {
    public boolean isCheckedOut;
    public User checkedOutBy;
    protected String title;
    protected int year;
    protected String author;

    public Media(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.isCheckedOut = false;
        this.checkedOutBy = null;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String printInfo() {
        return "";
    }

    public String unavailable() {
        return "";
    }

    public String notValid() {
        return "";
    }
}
