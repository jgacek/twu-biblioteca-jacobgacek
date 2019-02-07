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

        verify(printStream).println("The Lightning Thief \n Harry Potter \n Narnia");
    }
}