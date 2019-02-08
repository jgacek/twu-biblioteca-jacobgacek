package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private PrintStream printStream;
    private BookShelf books;
    private final String[] menuOptions = {"List of books"};

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.books = new BookShelf();
        LibraryBook bookOne = new LibraryBook("The Lightning Thief","Rick Riordan", 2005);
        LibraryBook bookTwo = new LibraryBook("Harry Potter", "J.K. Rowling", 1997);
        LibraryBook bookThree = new LibraryBook("Narnia", "C.S. Lewis", 1950);
        books.addBook(bookOne);
        books.addBook(bookTwo);
        books.addBook(bookThree);
    }

    public void printListOfBooks() {
        String formattedString = this.books.availableBookList();
        printStream.printf(formattedString);
    }

    public void printMenu() {
        String output = "";
        for (String s:menuOptions) {
            output = output + s + "\n";
        }
        printStream.print(output);
    }

    private boolean checkIfOptionIsValid(String selectedOption){
        for (String s:menuOptions) {
            if (selectedOption.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private void handleSelectedOption(String option) {
        if (option.equals("List of books")) {
            printListOfBooks();
        }
    }

    public void verifySelectedOption(String selectedOption){
        if (checkIfOptionIsValid(selectedOption) == false){
            printStream.println("Please select a valid option");
        } else {
            handleSelectedOption(selectedOption);
        }
    }

    public void printWelcomeMessage () {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.printMenu();
    }

}
