package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Isbn}
 */
public class IsbnTest {

    @Test
    void twoIsbns_withSameData_shouldBeEqual() {

        Edition edition = new Edition();
        String isbn = "978-0-5903-5340-3";

        Isbn isbn1 = new Isbn();
        Isbn isbn2 = new Isbn();

        isbn1.setEdition(edition);
        isbn2.setEdition(edition);
        isbn1.setIsbn(isbn);
        isbn2.setIsbn(isbn);

        assertEquals(isbn1, isbn2);
        assertEquals(isbn1.hashCode(), isbn2.hashCode());
    }

    @Test
    void twoIsbns_withDiffEdition_shouldNotBeEqual() {

        Edition edition1 = new Edition();
        Edition edition2 = new Edition();
        String isbn = "978-0-5903-5340-3";

        Isbn isbn1 = new Isbn();
        Isbn isbn2 = new Isbn();

        isbn1.setEdition(edition1);
        isbn2.setEdition(edition2);
        isbn1.setIsbn(isbn);
        isbn2.setIsbn(isbn);

        assertNotEquals(isbn1, isbn2);
    }

    @Test
    void twoIsbn_withDiffIsbns_shouldNotBeEqual() {

        Edition edition = new Edition();
        String isbnNum1 = "978-0-5903-5340-3";
        String isbnNum2 = "978-0-5903-5340-7";

        Isbn isbn1 = new Isbn();
        Isbn isbn2 = new Isbn();

        isbn1.setEdition(edition);
        isbn2.setEdition(edition);
        isbn1.setIsbn(isbnNum1);
        isbn2.setIsbn(isbnNum2);

        assertNotEquals(isbn1, isbn2);
    }

    @Test
    void Isbn_notEqualNull() {
        Isbn isbn = new Isbn();
        assertNotEquals(null, isbn);
    }

    @Test
    void Isbn_notEqualsDiffClass() {
        Isbn isbn = new Isbn();
        assertNotEquals(new Object(), isbn);
    }

}
