package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link IsbnId}
 */
public class IsbnIdTest {

    @Test
    void twoIsbnIds_withSameData_shouldBeEqual() {

        long edition = 123456789L;
        String isbn = "978-0-5903-5340-3";

        IsbnId isbnId1 = new IsbnId();
        IsbnId isbnId2 = new IsbnId();

        isbnId1.setEditionId(edition);
        isbnId2.setEditionId(edition);
        isbnId1.setIsbn(isbn);
        isbnId2.setIsbn(isbn);

        assertTrue(isbnId1.equals(isbnId2));
        assertTrue(isbnId1.hashCode() == isbnId2.hashCode());
    }

    @Test
    void twoIsbnIds_withDiffEdition_shouldNotBeEqual() {
        long edition1 = 123456789L;
        long edition2 = 987654321L;
        String isbn = "978-0-5903-5340-3";

        IsbnId isbnId1 = new IsbnId();
        IsbnId isbnId2 = new IsbnId();

        isbnId1.setEditionId(edition1);
        isbnId2.setEditionId(edition2);
        isbnId1.setIsbn(isbn);
        isbnId2.setIsbn(isbn);

        assertFalse(isbnId1.equals(isbnId2));
    }

    @Test
    void twoIsbnIds_withDiffIsbns_shouldNotBeEqual() {
        long edition = 123456789L;
        String isbn1 = "978-0-5903-5340-3";
        String isbn2 = "978-0-5903-5340-7";

        IsbnId isbnId1 = new IsbnId();
        IsbnId isbnId2 = new IsbnId();

        isbnId1.setEditionId(edition);
        isbnId2.setEditionId(edition);
        isbnId1.setIsbn(isbn1);
        isbnId2.setIsbn(isbn2);

        assertFalse(isbnId1.equals(isbnId2));
    }

    @Test
    void IsbnId_notEqualNull() {
        IsbnId isbnId = new IsbnId();
        assertFalse(isbnId.equals(null));
    }

    @Test
    void IsbnId_notEqualsDiffClass() {
        IsbnId isbnId = new IsbnId();
        assertFalse(isbnId.equals(new Object()));
    }

}
