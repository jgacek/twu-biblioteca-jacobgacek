package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private PrintStream printStream;
    private Shelf books;
    private Shelf movies;
    private Menu menu;
    private Scanner keyboard = new Scanner(System.in);
    private User currentUser;
    private ArrayList<User> allUsers;
    private Librarian librarian;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.books = new Shelf(new ArrayList<LibraryBook>());
        this.movies = new Shelf(new ArrayList<Movie>());
        this.menu = new Menu();
        this.currentUser = new User("Test User");
        this.allUsers = new ArrayList<User>();
        this.allUsers.add(currentUser);
        this.allUsers.add(new User("Test User 2"));
        this.librarian = new Librarian("Test Librarian",allUsers);
        this.allUsers.add(librarian);
        LibraryBook bookOne = new LibraryBook("The Lightning Thief","Rick Riordan", 2005);
        LibraryBook bookTwo = new LibraryBook("Harry Potter", "J.K. Rowling", 1997);
        LibraryBook bookThree = new LibraryBook("Narnia", "C.S. Lewis", 1950);
        books.addItem(bookOne);
        books.addItem(bookTwo);
        books.addItem(bookThree);
        Movie movieOne = new Movie("The Lord of the Rings","Peter Jackson",2001,9);
        Movie movieTwo = new Movie("The Godfather","Francis Ford Coppola",1972,9);
        Movie movieThree = new Movie("Tangled","Byron Howard",2010,8);
        movies.addItem(movieOne);
        movies.addItem(movieTwo);
        movies.addItem(movieThree);
    }

    public void printListOfBooks() {
        String formattedString = this.books.availableItems();
        printStream.printf(formattedString);
    }

    public void printListOfMovies() {
        String formattedString = this.movies.availableItems();
        printStream.printf(formattedString);
    }

    public void printMenu() {
        printStream.print(menu.printMenu());
    }

    private void handleSelectedOption(String option) {
        if (option.equals("List of books")) {
            printListOfBooks();
        }
        if (option.equals("List of movies")) {
            printListOfMovies();
        }
        if (option.startsWith("Checkout")) {
            printStream.println("Would you like to checkout a book or a movie?");
            String title = this.keyboard.nextLine();
            if (title.equals("book")) {
                printStream.println("Which book would you like to checkout");
                title = this.keyboard.nextLine();
                printStream.println(books.checkOut(title,currentUser));
            } else if (title.equals("movie")) {
                printStream.println("Which movie would you like to checkout");
                title = this.keyboard.nextLine();
                printStream.println(movies.checkOut(title,currentUser));
            }
        }
        if (option.startsWith("Return")) {
            printStream.println("Would you like to return a book or a movie");
            String title = this.keyboard.nextLine();
            if (title.equals("book")) {
                printStream.println("Which book would you like to return");
                title = this.keyboard.nextLine();
                printStream.println(books.returnItem(title));
            } else if (title.equals("movie")) {
                printStream.println("Which movie would you like to return");
                title = this.keyboard.nextLine();
                printStream.println(movies.returnItem(title));
            }
        }
        if (option.startsWith("My items")) {
            printStream.printf(currentUser.myItems());
        }
        if (option.equals("Switch user")) {
            printStream.println("Please type in name of user");
            String newUser = this.keyboard.nextLine();
            for (User u : allUsers) {
                if (u.getName().equals(newUser)) {
                    this.currentUser = u;
                    break;
                }
            }
        }
        if (option.equals("Print checked out items")) {
            if (currentUser instanceof Librarian) {
                printStream.printf(((Librarian) currentUser).printAllCheckedOutItems());
            } else {
                printStream.println("Sorry only librarians have access to this funciton");
            }
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
