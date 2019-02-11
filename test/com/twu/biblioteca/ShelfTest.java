package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShelfTest {

    @Test
    public void availableBookList() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        String title = "Title";
        String author = "Author";
        String year = "Year";
        String expectedList = String.format("%-22s%-22s%-22s\n",title,author,year);
        expectedList = expectedList + String.format("%-22s%-22s%-22d\n","a","a",1);

        assertEquals(expectedList,bookShelf.availableItems());
    }

    @Test
    public void reduceBookListWhenBookIsCheckedOut() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        bookShelf.checkOut("a",new User("a"));
        String title = "Title";
        String author = "Author";
        String year = "Year";
        String expectedList = String.format("%-22s%-22s%-22s\n",title,author,year);

        assertEquals(expectedList,bookShelf.availableItems());
    }

    @Test
    public void shouldFailToCheckOutWhenBookDoesntExist() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        assertEquals("Sorry, that book is not available",bookShelf.checkOut("b",new User("b")));
    }

    @Test
    public void shouldSucceedInCheckingOutBook() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        assertEquals("Thank you! Enjoy the book",bookShelf.checkOut("a",new User("a")));
    }

    @Test
    public void shouldRedisplayBookAfterReturned() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        bookShelf.checkOut("a",new User("a"));
        bookShelf.returnItem("a");

        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String expectedList = String.format("%-22s%-22s%-22s\n",title,author,year);
        expectedList = expectedList + String.format("%-22s%-22s%-22d\n","a","a",1);

        assertEquals(expectedList,bookShelf.availableItems());
    }

    @Test
    public void shouldSucceedInReturningBook() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        bookShelf.checkOut("a",new User("a"));
        assertEquals("Thank you for returning the book",bookShelf.returnItem("a"));
    }

    @Test
    public void shouldFailInReturningBook() {
        Shelf bookShelf = new Shelf(new ArrayList<LibraryBook>());
        bookShelf.addItem(new LibraryBook("a","a",1));

        assertEquals("That is not a valid book to return",bookShelf.returnItem("a"));
    }
}