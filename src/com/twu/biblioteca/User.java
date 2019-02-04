package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String library_number;
    private String password;

    private ArrayList<Book> my_books;
    private ArrayList<Movie> my_movies;

    public User(String library_number, String password) {
        this.library_number = library_number;
        this.password = password;

        my_books = new ArrayList<>();
        my_movies = new ArrayList<>();
    }

    public String getLibrary_number() {
        return library_number;
    }

    public boolean isPassword(String password) {
        return password.equals(this.password);
    }

    public ArrayList<Book> getMy_books() {
        return my_books;
    }

    public ArrayList<Movie> getMy_movies() {
        return my_movies;
    }
}
