package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class BibliotecaApp {
    private ArrayList<Book> catalog;
    private ArrayList<Book> checked_out_books;

    public BibliotecaApp() {
        // welcome message
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        catalog = new ArrayList<>();
        checked_out_books = new ArrayList<>();

        // for TDD
        catalog.add(new Book("Invisible Man", "Ralph Ellison", 1952));
        catalog.add(new Book("Shook One", "Charlamagne Tha God", 2018));
        catalog.add(new Book("Duma Key", "Stephen King", 2008));
    }

    // main menu to be shown until user exits.
    public void displayMenu() {
        System.out.println("\nWhat would you like to do?");

        System.out.println("l - List of Books");
        System.out.println("c - Check out a book");
        System.out.println("r - Return a book");
        System.out.println("q - Quit");

        System.out.println();
    }

    // handles menu selection from command line
    public void navigateMenu(Scanner input) {
        switch (input.nextLine()) {
            case "l":
                listBooks();
                break;

            case "c":
                System.out.println("Please enter the title of the book you want to check out:");
                checkOut(input.nextLine());
                break;

            case "r":
                System.out.println("Please enter the title of the book you want to return:");
                returnBook(input.nextLine());
                break;

            case "q":
                System.out.println("Goodbye!");
                exit(0);

            default:
                System.out.println("Please select a valid option!");
        }
    }


    public void listBooks() {
        String list = "Here is a list of our books:\n";
        list += "TITLE - AUTHOR - YEAR PUBLISHED\n\n";

        for (Book book : catalog) {
            list += book.getTitle() + " - " + book.getAuthor() + " - " + book.getPublish_year() + "\n";
        }

        System.out.println(list);
    }

    public boolean hasBooks() {
        return !catalog.isEmpty();
    }

    // menu option to check out a book
    public void checkOut(String title) {
        int last_index;

        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                checked_out_books.add(book);
                break;
            }
        }

        last_index = checked_out_books.size() - 1;

        // book was successfully located & checked out
        if (last_index > -1) {
            catalog.remove(checked_out_books.get(last_index));
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("Sorry, that book is not available");
        }
    }

    // menu option to return a book
    public void returnBook(String title) {
        int last_index = catalog.size() - 1;

        for (Book checked_out : checked_out_books) {
            if (checked_out.getTitle().equals(title)) {
                catalog.add(checked_out);
                break;
            }
        }

        // book was added
        if (last_index != catalog.size() - 1) {
            last_index = catalog.size() - 1;
            checked_out_books.remove(catalog.get(last_index));
            System.out.println("Thank you for returning the book");
        }
        else {
            System.out.println("That is not a valid book to return");
        }
    }


    /** for TDD */
    public boolean hasAvailable(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BibliotecaApp library = new BibliotecaApp();


        while (true) {
            library.displayMenu();
            library.navigateMenu(input);
        }
    }

}
