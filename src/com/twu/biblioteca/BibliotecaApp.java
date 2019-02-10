package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {

    private PrintStream printStream;
    private Shelf books;
    private Menu menu;
    private Scanner keyboard = new Scanner(System.in);

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.books = new Shelf();
        this.menu = new Menu();
        LibraryBook bookOne = new LibraryBook("The Lightning Thief","Rick Riordan", 2005);
        LibraryBook bookTwo = new LibraryBook("Harry Potter", "J.K. Rowling", 1997);
        LibraryBook bookThree = new LibraryBook("Narnia", "C.S. Lewis", 1950);
        books.addItem(bookOne);
        books.addItem(bookTwo);
        books.addItem(bookThree);
    }

    public void printListOfBooks() {
        String formattedString = this.books.availableItems();
        printStream.printf(formattedString);
    }

    public void printMenu() {
        printStream.print(menu.printMenu());
    }

    private void handleSelectedOption(String option) {
        if (option.equals("List of books")) {
            printListOfBooks();
        }
        if (option.startsWith("Checkout")) {
            printStream.println("Which book would you like to checkout?");
            String bookTitle = this.keyboard.nextLine();
            printStream.println(books.checkOut(bookTitle));

        }
        if (option.startsWith("Return")) {
            printStream.println("Which book would you like to return?");
            String bookTitle = this.keyboard.nextLine();
            printStream.println(books.returnItem(bookTitle));
        }
        if (option.equals("Quit")){
            System.exit(0);
        }
        printMenu();
    }

    public void verifySelectedOption(String selectedOption){
        if (menu.checkIfValidOption(selectedOption) == false){
            printStream.println("Please select a valid option");
            printMenu();
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
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();
        while(!option.equals("Quit")){
            bibliotecaApp.verifySelectedOption(option);
            option = keyboard.nextLine();
        }
    }

}
