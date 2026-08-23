package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit tests for {@link Edition}.
 */
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
        assertTrue(author.getEditions().contains(edition));
    }

    @Test
    void addAuthorTwice_shouldNotDuplicateAuthorInSet() {
        Edition edition = new Edition();
        Author author = new Author();

        edition.addAuthor(author);
        edition.addAuthor(author);

        assertEquals(1, edition.getAuthors().size());
    }

    @Test
    void removeAuthor_shouldRemoveAuthorFromSet() {
        Edition edition = new Edition();
        Author author = new Author();

        edition.addAuthor(author);
        edition.removeAuthor(author);

        assertTrue(edition.getAuthors().isEmpty());
        assertTrue(author.getEditions().isEmpty());
    }


    // Publisher tests

    @Test
    void addPublisher_shouldAddPublisherToSet() {
        Edition edition = new Edition();
        Publisher publisher = new Publisher();

        edition.addPublisher(publisher);

        assertTrue(edition.getPublishers().contains(publisher));
        assertTrue(publisher.getEditions().contains(edition));
    }

    @Test
    void addPublisherTwice_shouldNotDuplicatePublisherInSet() {
        Edition edition = new Edition();
        Publisher publisher = new Publisher();

        edition.addPublisher(publisher);
        edition.addPublisher(publisher);

        assertEquals(1, edition.getPublishers().size());
    }

    @Test
    void removePublisher_shouldRemovePublisherFromSet() {
        Edition edition = new Edition();
        Publisher publisher = new Publisher();

        edition.addPublisher(publisher);
        edition.removePublisher(publisher);

        assertTrue(edition.getPublishers().isEmpty());
        assertTrue(publisher.getEditions().isEmpty());

    }

}
