package com.twu.biblioteca;

import java.util.ArrayList;

public class BookShelf {
    private ArrayList<LibraryBook> allBooks;

    public BookShelf(){
        this.allBooks = new ArrayList<LibraryBook>();
    }

    public void addBook(LibraryBook book) {
        this.allBooks.add(book);
    }

    public String availableBookList() {
        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String listOfBooks = String.format("%-22s%-22s%-22s\n",title,author,year);
        for (LibraryBook book:allBooks) {
            if (!book.isCheckedOut) {
                    listOfBooks = listOfBooks + String.format("%-22s%-22s%-22d\n",
                            book.getTitle(),book.getAuthor(),book.getYearPublished());
            }
        }
        return listOfBooks;
    }

    public String checkOut(String bookName){
        for (LibraryBook book:allBooks) {
            if (!book.isCheckedOut){
                if (bookName.equals(book.getTitle())){
                    book.isCheckedOut = true;
                    return "Thank you! Enjoy the book";
                }
            }
        }
        return "Sorry, that book is not available";
    }

    public String returnBook(String bookTitle) {
        for (LibraryBook book:allBooks) {
            if (bookTitle.equals(book.getTitle())) {
                if (book.isCheckedOut) {
                    book.isCheckedOut = false;
                    return "Thank you for returning the book";
                }
            }
        }
        return "That is not a valid book to return";
    }
}
