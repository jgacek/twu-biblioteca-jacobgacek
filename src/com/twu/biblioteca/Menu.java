package com.twu.biblioteca;

public class Menu {
    private String[] menuOptions = {"List of books","List of movies","Checkout","Return","My items","Switch user",
            "Print checked out items","Quit"};

    public boolean checkIfValidOption(String selectedOption) {
        for (String s:menuOptions) {
            if (selectedOption.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public String printMenu() {
        String output = "";
        for (String s:menuOptions) {
            output = output + s + "\n";
        }
        return output;
    }
}
