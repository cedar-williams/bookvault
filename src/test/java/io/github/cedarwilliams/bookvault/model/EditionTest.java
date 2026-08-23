package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EditionTest {

    // ISBN tests

    @Test
    void addIsbn_shouldAddIsbnToSet() {
        Edition edition = new Edition();
        Isbn isbn = new Isbn();

        edition.addIsbn(isbn);

        assertTrue(edition.getIsbns().contains(isbn));
        assertEquals(edition, isbn.getEdition());
    }

    @Test
    void addIsbnTwice_shouldNotDuplicateIsbnInSet() {
        Edition edition = new Edition();
        Isbn isbn = new Isbn();

        edition.addIsbn(isbn);
        edition.addIsbn(isbn);

        assertEquals(1, edition.getIsbns().size());
    }

    @Test
    void removeIsbn_shouldRemoveIsbnFromSet() {
        Edition edition = new Edition();
        Isbn isbn = new Isbn();

        edition.addIsbn(isbn);
        edition.removeIsbn(isbn);

        assertTrue(edition.getIsbns().isEmpty());
        assertNull(isbn.getEdition());
    }


    // Author tests

    @Test
    void addAuthor_shouldAddAuthorToSet() {
        Edition edition = new Edition();
        Author author = new Author();

        edition.addAuthor(author);

        assertTrue(edition.getAuthors().contains(author));
        assertTrue(author.get);
    }

    // Publisher tests
}
