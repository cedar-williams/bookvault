package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Publisher}.
 */
public class PublisherTest {

    // Edition tests

    @Test
    void addEdition_shouldAddEditionToSet() {
        Publisher publisher = new Publisher();
        Edition edition = new Edition();

        publisher.addEdition(edition);

        assertTrue(publisher.getEditions().contains(edition));
        assertTrue(edition.getPublishers().contains(publisher));
    }

    @Test
    void addEditionTwice_shouldNotDuplicateEditionInSet() {
        Publisher publisher = new Publisher();
        Edition edition = new Edition();

        publisher.addEdition(edition);
        publisher.addEdition(edition);

        assertEquals(1, publisher.getEditions().size());
    }

    @Test
    void removeEdition_shouldRemoveEditionFromSet() {
        Publisher publisher = new Publisher();
        Edition edition = new Edition();

        publisher.addEdition(edition);
        publisher.removeEdition(edition);

        assertTrue(publisher.getEditions().isEmpty());
        assertTrue(edition.getPublishers().isEmpty());
    }

}
