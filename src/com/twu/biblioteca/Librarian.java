package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian extends User {
    private ArrayList<User> allUsers;

    public Librarian(String name, ArrayList<User> allUsers) {
        super(name);
        this.allUsers = allUsers;
    }

    public void addUserToList(User user) {
        allUsers.add(user);
    }

    public String printAllCheckedOutItems() {
        String allItems = "";
        for (User u : allUsers) {
            String temp = printOutUserItems(u.getName());
            allItems = allItems + u.getName() + "\n" + temp;
        }
        return allItems;
    }

    public String printOutUserItems(String user){
        for (User u : allUsers) {
            if (u.getName().equals(user)){
                return u.myItems();
            }
        }
        return "This user has no items currently checked out\n";
    }
}
