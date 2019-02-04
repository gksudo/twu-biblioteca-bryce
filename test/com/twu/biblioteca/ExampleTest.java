package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ExampleTest {
    @Test
    @Ignore
    public void test() {
        assertThat(1, is(1));
    }

    @Test
    @Ignore
    public void bibliotecaHasBooks() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasBooks(), is(true));
    }

    @Test
    public void bookHasBeenCheckedOut() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasBook("Invisible Man"), is(true));
        library.checkOutBook("Invisible Man");
        assertThat(library.hasBook("Invisible Man"), is(false));
    }

    @Test
    public void bookHasBeenReturned() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasBook("Invisible Man"), is(true));
        library.checkOutMovie("Invisible Man");
        assertThat(library.hasBook("Invisible Man"), is(false));
        library.returnBook("Invisible Man");
        assertThat(library.hasBook("Invisible Man"), is(true));
    }

    @Test
    @Ignore
    public void biliotecaHasMovies() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasMovies(), is(true));
    }

    @Test
    public void movieHasBeenCheckedOut() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasMovie("Roma"), is(true));
        library.checkOutMovie("Roma");
        assertThat(library.hasMovie("Roma"), is(false));
    }

    @Test
    public void movieHasBeenReturned() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasMovie("Roma"), is(true));
        library.checkOutMovie("Roma");
        assertThat(library.hasMovie("Roma"), is(false));
        library.returnMovie("Roma");
        assertThat(library.hasMovie("Roma"), is(true));
    }

    @Test
    public void bibliotecaHasUsers() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasUsers(), is(true));
    }
}
