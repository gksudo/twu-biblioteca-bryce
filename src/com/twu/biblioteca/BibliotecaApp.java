package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> catalog;

    public BibliotecaApp() {
        // welcome message
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        catalog = new ArrayList<>();

        // for TDD
        catalog.add(new Book("Invisible Man", "Ralph Ellison", 1952));
        catalog.add(new Book("Shook One", "Charlamagne Tha God", 2018));
        catalog.add(new Book("Duma Key", "Stephen King", 2008));
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


    public static void main(String[] args) {

        BibliotecaApp library = new BibliotecaApp();

        library.listBooks();
    }

}
