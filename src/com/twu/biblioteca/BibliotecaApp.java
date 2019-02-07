package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
    }


    public void printWelcomeMessage () {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out);
        bibliotecaApp.printWelcomeMessage();
    }

}
