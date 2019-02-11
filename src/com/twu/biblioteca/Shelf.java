package com.twu.biblioteca;

import java.util.ArrayList;

public class Shelf<T extends Media> {
    private ArrayList<T> allItems;

    public Shelf(ArrayList<T> items){
        this.allItems = items;
    }

    public void addItem(T item) {
        this.allItems.add(item);
    }

    public String availableItems() {
        String title = "Title";
        String author = "Author";
        String year = "Year";
        String listOfItems;
        if (allItems.get(0) instanceof Movie){
            listOfItems = String.format("%-22s%-22s%-22s%-22s\n",title,author,year,"Rating");
        } else {
            listOfItems = String.format("%-22s%-22s%-22s\n", title, author, year);
        }
        for (Media item: allItems) {
            if (!item.isCheckedOut) {
                    listOfItems = listOfItems + item.printInfo();
            }
        }
        return listOfItems;
    }

    public String checkOut(String itemName){
        for (Media item: allItems) {
            if (!item.isCheckedOut){
                if (itemName.equals(item.getTitle())){
                    item.isCheckedOut = true;
                    return "Thank you! Enjoy the item";
                }
            }
        }
        return allItems.get(0).unavailable();
    }

    public String returnItem(String itemTitle) {
        for (Media item: allItems) {
            if (itemTitle.equals(item.getTitle())) {
                if (item.isCheckedOut) {
                    item.isCheckedOut = false;
                    return "Thank you for returning the item";
                }
            }
        }
        return allItems.get(0).notValid();
    }
}
