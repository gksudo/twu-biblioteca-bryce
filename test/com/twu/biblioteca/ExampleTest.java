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

        assertThat(library.hasAvailable("Invisible Man"), is(true));
        library.checkOut("Invisible Man");
        assertThat(library.hasAvailable("Invisible Man"), is(false));
    }

    @Test
    public void bookHasBeenReturned() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasAvailable("Invisible Man"), is(true));
        library.checkOut("Invisible Man");
        assertThat(library.hasAvailable("Invisible Man"), is(false));
        library.returnBook("Invisible Man");
        assertThat(library.hasAvailable("Invisible Man"), is(true));
    }
}
