package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookShelfTest {

    @Test
    public void availableBookList() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new LibraryBook("a","a",1));

        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String expectedList = String.format("%-22s%-22s%-22s\n",title,author,year);
        expectedList = expectedList + String.format("%-22s%-22s%-22d\n","a","a",1);

        assertEquals(expectedList,bookShelf.availableBookList());
    }

    @Test
    public void reduceBookListWhenBookIsCheckedOut() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new LibraryBook("a","a",1));

        bookShelf.checkOut("a");
        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String expectedList = String.format("%-22s%-22s%-22s\n",title,author,year);

        assertEquals(expectedList,bookShelf.availableBookList());
    }
}