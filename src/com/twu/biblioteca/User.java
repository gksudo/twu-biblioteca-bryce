package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String library_number;
    private String password;

    private String name;
    private String email;
    private String phone_number;

    private ArrayList<Book> my_books;
    private ArrayList<Movie> my_movies;

    public User(String library_number, String password, String name, String email, String phone_number) {
        this.library_number = library_number;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;

        my_books = new ArrayList<>();
        my_movies = new ArrayList<>();
    }

    public String getLibrary_number() {
        return library_number;
    }

    // "password validation"
    public boolean isPassword(String password) {
        return password.equals(this.password);
    }

    public ArrayList<Book> getMy_books() {
        return my_books;
    }

    public void checkOutBook(Book title) {
        my_books.add(title);
    }

    public void returnBook(Book title) {
        my_books.remove(title);
    }

    public ArrayList<Movie> getMy_movies() {
        return my_movies;
    }

    public void checkOutMovie(Movie name) {
        my_movies.add(name);
    }

    public void returnMovie(Movie name) {
        my_movies.remove(name);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone_number.substring(0,3) + "-" + phone_number.substring(3,7);
    }
}
