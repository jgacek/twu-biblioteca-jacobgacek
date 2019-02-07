package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
    }

    public void printListOfBooks() {
        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String[] books = {"The Lightning Thief", "Harry Potter", "Narnia"};
        String[] authors = {"Rick Riordan", "J.K. Rowling", "C.S. Lewis"};
        String[] published = {"2005","1997","1950"};
        printStream.printf("%-22s%-22s%-22s\n%-22s%-22s%-22s\n%-22s%-22s%-22s\n%-22s%-22s%-22s",
                                            title,author,year,
                                            books[0],authors[0],published[0],
                                            books[1],authors[1],published[1],
                                            books[2],authors[2],published[2]);
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
