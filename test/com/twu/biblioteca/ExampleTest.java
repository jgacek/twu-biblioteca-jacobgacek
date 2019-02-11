package com.twu.biblioteca;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    @Test
    public void shouldWelcomeUserWhenStartingApp() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);

        bibliotecaApp.printWelcomeMessage();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldPrintListOfBooksAfterSelectingOption() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);

        bibliotecaApp.verifySelectedOption("List of books");

        String wantedString = String.format("%-22s%-22s%-22s\n%-22s%-22s%-22d\n%-22s%-22s%-22d\n%-22s%-22s%-22d\n",
                "Title","Author","Year Published",
                "The Lightning Thief","Rick Riordan",2005,
                "Harry Potter","J.K. Rowling",1997,
                "Narnia","C.S. Lewis",1950);

        verify(printStream).printf(wantedString);
    }

    @Test
    public void shouldPrintMenu() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);

        bibliotecaApp.printMenu();

        verify(printStream).print("List of books\nList of movies\nCheckout\nReturn\nMy items\nSwitch user\nPrint checked out items\nQuit\n");
    }

    @Test
    public void shouldPrintInvalidAfterChoosingInvalidOption() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);

        bibliotecaApp.verifySelectedOption("asd");

        verify(printStream).println("Please select a valid option");
    }

    @Test
    public void shouldRemoveBookFromListAfterCheckingOut() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);
    }

}