package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class BibliotecaApp {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;
    private User logged_in;

    public BibliotecaApp(String library_number, String password) {

    }

    public BibliotecaApp() {
        // welcome message
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        books = new ArrayList<>();
        movies = new ArrayList<>();
        users = new ArrayList<>();

        // for TDD
        books.add(new Book("Invisible Man", "Ralph Ellison", 1952));
        books.add(new Book("Shook One", "Charlamagne Tha God", 2018));
        books.add(new Book("Duma Key", "Stephen King", 2008));

        movies.add(new Movie("Bumblebee", 2018, "Travis Knight", 9));
        movies.add(new Movie("Vice", 2018, "Adam McKay", 4));
        movies.add(new Movie("Roma", 2018, "Alfonso Cuaron", 0));

        users.add(new User("123-4567", "pass", "John Porter", "email@gmail.com", "5555039"));
        users.add(new User("765-4321", "word", "Sam Green", "address@gmail.com", "4438905"));
    }

    // login screen to be shown before the menu
    public void logIn(Scanner input) {
        String l_number;
        String password;

        System.out.println("Please log in. Type 'exit' to leave.");

        while (logged_in == null) {
            System.out.println("Library Number: ");

            l_number = input.nextLine();
            if (l_number.equals("exit")) exit(0);

            System.out.println("Password: ");
            password = input.nextLine();
            if (password.equals("exit")) exit(0);

            for (User account : users) {
                if (account.getLibrary_number().equals(l_number)
                    && account.isPassword(password)) {
                    logged_in = account;
                    break;
                }
            }

            if (logged_in == null) System.out.println("Sorry, that user doesn't exist.");
        }

        System.out.println("Welcome, " + logged_in.getName());
    }



    // main menu to be shown until user exits.
    public void displayMenu() {
        System.out.println("\nWhat would you like to do?");

        System.out.println("1 - List of books");
        System.out.println("2 - List of movies");
        System.out.println("3 - Check out a book");
        System.out.println("4 - Check out a movie");
        System.out.println("5 - Return a book");
        System.out.println("6 - Return a movie");
        System.out.println("7 - View account info");
        System.out.println("q - Quit");

        System.out.println();
    }

    // handles menu selection from command line
    public void navigateMenu(Scanner input) {
        switch (input.nextLine()) {
            case "1":
                listBooks();
                break;

            case "2":
                listMovies();
                break;

            case "3":
                System.out.println("Please enter the title of the book you want to check out:");
                checkOutBook(input.nextLine());
                break;

            case "4":
                System.out.println("Please enter the title of the movie you want to check out:");
                checkOutMovie(input.nextLine());
                break;

            case "5":
                System.out.println("Please enter the title of the book you want to return:");
                returnBook(input.nextLine());
                break;

            case "6":
                System.out.println("Please enter the title of the movie you want to return:");
                returnMovie(input.nextLine());
                break;

            case "7":
                System.out.println("NAME - EMAIL ADDRESS - PHONE NUMBER");
                System.out.println("" + logged_in.getName() + " - " + logged_in.getEmail() + " - " + logged_in.getPhone());
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

        for (Book book : books) {
            list += book.getTitle() + " - " + book.getAuthor() + " - " + book.getPublish_year() + "\n";
        }

        System.out.println(list);
    }

    private void listMovies() {
        String list = "Here is a list of our movies:\n";
        list += "NAME - YEAR - DIRECTOR - RATING\n\n";

        for (Movie movie : movies) {
            list += movie.getName() + " - " + movie.getYear() + " - " + movie.getDirector() + " - " + movie.getRating() + "\n";
        }

        System.out.println(list);
    }

    // menu option to check out a book
    public void checkOutBook(String title) {
        int last_index;

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                logged_in.checkOutBook(book);
                break;
            }
        }

        last_index = logged_in.getMy_books().size() - 1;

        // book was successfully located & checked out
        if (last_index > -1) {
            books.remove(logged_in.getMy_books().get(last_index));
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("Sorry, that book is not available");
        }
    }

    // menu option to check out a movie
    public void checkOutMovie(String name) {
        int last_index;

        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                logged_in.checkOutMovie(movie);
                break;
            }
        }

        last_index = logged_in.getMy_movies().size() - 1;

        // movie was successfully located & checked out
        if (last_index > -1) {
            movies.remove(logged_in.getMy_movies().get(last_index));
            System.out.println("Thank you! Enjoy the movie");
        }
        else {
            System.out.println("Sorry, that movie is not available");
        }
    }

    // menu option to return a book
    public void returnBook(String title) {
        int last_index = books.size() - 1;

        for (Book checked_out : logged_in.getMy_books()) {
            if (checked_out.getTitle().equals(title)) {
                books.add(checked_out);
                break;
            }
        }

        // book was added
        if (last_index != books.size() - 1) {
            last_index = books.size() - 1;
            logged_in.returnBook(books.get(last_index));
            System.out.println("Thank you for returning the book");
        }
        else {
            System.out.println("That is not a valid book to return");
        }
    }

    // menu option to return a movie
    public void returnMovie(String name) {
        int last_index = movies.size() - 1;

        for (Movie checked_out : logged_in.getMy_movies()) {
            if (checked_out.getName().equals(name)) {
                movies.add(checked_out);
                break;
            }
        }

        // movie was added
        if (last_index != movies.size() - 1) {
            last_index = movies.size() - 1;
            logged_in.returnMovie(movies.get(last_index));
            System.out.println("Thank you for returning the movie");
        }
        else {
            System.out.println("That is not a valid movie to return");
        }
    }


    /** for TDD */
    public boolean hasBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasBooks() {
        return !books.isEmpty();
    }

    public boolean hasMovies() {
        return !movies.isEmpty();
    }

    public boolean hasUsers() {
        return !users.isEmpty();
    }

    public void logIn(String library_number, String password) {
        for (User account : users) {
            if (account.getLibrary_number().equals(library_number)
                    && account.isPassword(password)) {
                logged_in = account;
                break;
            }
        }
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BibliotecaApp library = new BibliotecaApp();

        library.logIn(input);

        while (true) {
            library.displayMenu();
            library.navigateMenu(input);
        }
    }
}
