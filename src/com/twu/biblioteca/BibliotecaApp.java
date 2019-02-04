package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> catalog;

    public BibliotecaApp() {
        // welcome message
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        catalog = new ArrayList<>();

        // for TDD
        catalog.add(new Book("Invisible Man"));
        catalog.add(new Book("Shook One"));
        catalog.add(new Book("Duma Key"));
    }


    public void listBooks() {
        String list = "Here is a list of our books:\n";

        for (Book book : catalog) {
            list += "\t" + book.getTitle() + "\n";
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
