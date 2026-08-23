package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Author}.
 */
public class AuthorTest {

    // Edition tests

    @Test
    void addEdition_shouldAddEditionToSet() {
        Author author = new Author();
        Edition edition = new Edition();

        author.addEdition(edition);

        assertTrue(author.getEditions().contains(edition));
        assertTrue(edition.getAuthors().contains(author));
    }

    @Test
    void addEditionTwice_shouldNotDuplicateEditionInSet() {
        Author author = new Author();
        Edition edition = new Edition();

        author.addEdition(edition);
        author.addEdition(edition);

        assertEquals(1, author.getEditions().size());
    }

    @Test
    void removeEdition_shouldRemoveEditionFromSet() {
        Author author = new Author();
        Edition edition = new Edition();

        author.addEdition(edition);
        author.removeEdition(edition);

        assertTrue(author.getEditions().isEmpty());
        assertTrue(edition.getAuthors().isEmpty());
    }

}
