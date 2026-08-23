package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Work}.
 */
public class WorkTest {

    // Edition tests

    @Test
    void addEdition_shouldAddEditionToSet() {
        Work work = new Work();
        Edition edition = new Edition();

        work.addEdition(edition);

        assertTrue(work.getEditions().contains(edition));
        assertEquals(work, edition.getWork());
    }

    @Test
    void addEditionTwice_shouldNotDuplicateEditionInSet() {
        Work work = new Work();
        Edition edition = new Edition();

        work.addEdition(edition);
        work.addEdition(edition);

        assertEquals(1, work.getEditions().size());
    }

    @Test
    void removeEdition_shouldRemoveEditionFromSet() {
        Work work = new Work();
        Edition edition = new Edition();

        work.addEdition(edition);
        work.removeEdition(edition);

        assertTrue(work.getEditions().isEmpty());
        assertNull(edition.getWork());
    }

}
