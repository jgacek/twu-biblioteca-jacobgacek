package com.twu.biblioteca;

import java.util.ArrayList;

public class Shelf {
    private ArrayList<Media> allItems;

    public Shelf(){
        this.allItems = new ArrayList<Media>();
    }

    public void addItem(Media item) {
        this.allItems.add(item);
    }

    public String availableItems() {
        String title = "Title";
        String author = "Author";
        String year = "Year Published";
        String listOfBooks = String.format("%-22s%-22s%-22s\n",title,author,year);
        for (Media item: allItems) {
            if (!item.isCheckedOut) {
                    listOfBooks = listOfBooks + String.format("%-22s%-22s%-22d\n",
                            item.getTitle(),item.getAuthor(),item.getYear());
            }
        }
        return listOfBooks;
    }

    public String checkOut(String bookName){
        for (Media item: allItems) {
            if (!item.isCheckedOut){
                if (bookName.equals(item.getTitle())){
                    item.isCheckedOut = true;
                    return "Thank you! Enjoy the item";
                }
            }
        }
        return "Sorry, that book is not available";
    }

    public String returnItem(String bookTitle) {
        for (Media item: allItems) {
            if (bookTitle.equals(item.getTitle())) {
                if (item.isCheckedOut) {
                    item.isCheckedOut = false;
                    return "Thank you for returning the item";
                }
            }
        }
        return "That is not a valid book to return";
    }
}
