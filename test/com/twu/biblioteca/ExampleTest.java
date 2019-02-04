package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ExampleTest {

    @Test
    public void test() {
        assertThat(1, is(1));
    }

    @Test
    public void bibliotecaHasBooks() {
        BibliotecaApp library = new BibliotecaApp();

        assertThat(library.hasBooks(), is(true));
    }
}
