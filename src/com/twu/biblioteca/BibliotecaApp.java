package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private PrintStream printStream;
    private ArrayList<LibraryBook> availableBooks;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.availableBooks = new ArrayList<LibraryBook>();
        LibraryBook bookOne = new LibraryBook("The Lightning Thief","Rick Riordan", 2005);
        LibraryBook bookTwo = new LibraryBook("Harry Potter", "J.K. Rowling", 1997);
        LibraryBook bookThree = new LibraryBook("Narnia", "C.S. Lewis", 1950);
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        availableBooks.add(bookThree);
    }

    private String formatListOfBooks() {
        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String formattedString = String.format("%-22s%-22s%-22s\n",title,author,year);
        for (LibraryBook book:availableBooks) {
            formattedString = formattedString + String.format("%-22s%-22s%-22d\n",
                                book.getTitle(),book.getAuthor(),book.getYearPublished());
        }
        return formattedString;
    }

    public void printListOfBooks() {
        String formattedString = this.formatListOfBooks();
        printStream.printf(formattedString);
    }


    public void printWelcomeMessage () {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.printListOfBooks();
    }

}
