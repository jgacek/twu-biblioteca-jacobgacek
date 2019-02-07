package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

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
    public void shouldPrintListOfBooksAfterWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);

        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.printListOfBooks();

        verify(printStream).printf("%-22s%-22s%-22s\n%-22s%-22s%-22s\n%-22s%-22s%-22s\n%-22s%-22s%-22s",
                                    "Title","Author","Year Published",
                                    "The Lightning Thief","Rick Riordan","2005",
                                    "Harry Potter","J.K. Rowling","1997",
                                    "Narnia","C.S. Lewis","1950");
    }
}