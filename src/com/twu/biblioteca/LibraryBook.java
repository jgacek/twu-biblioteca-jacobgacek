package com.twu.biblioteca;

public class LibraryBook extends Media {

    public LibraryBook(String title, String author, int year){
        super(title, year, author);
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String printInfo() {
        String info;
        info = String.format("%-22s%-22s%-22d\n",
                this.getTitle(),this.getAuthor(),this.getYear());
        return info;
    }

    @Override
    public String unavailable() {
        return "Sorry, that book is not available";
    }

    @Override
    public String notValid() {
        return "That is not a valid book to return";
    }

}
