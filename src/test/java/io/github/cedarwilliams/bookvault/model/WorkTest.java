package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getDisplayTitle_nullSubTitle_shouldReturnTitle() {
        Work work = new Work();
        work.setTitle("Title");

        assertNotEquals("", work.getSubtitle());
        assertEquals("Title", work.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_blankSubTitle_shouldReturnTitle() {
        Work work = new Work();
        work.setTitle("Title");
        work.setSubtitle("");

        assertNotEquals(null, work.getSubtitle());
        assertEquals("Title", work.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_spacesSubTitle_shouldReturnTitle() {
        Work work = new Work();
        work.setTitle("Title");
        work.setSubtitle("      ");

        assertNotEquals(null, work.getSubtitle());
        assertEquals("Title", work.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_withSubTitle_shouldReturnTitleAndSubtitle() {
        Work work = new Work();
        work.setTitle("Title");
        work.setSubtitle("Subtitle");

        assertEquals("Title: Subtitle", work.getDisplayTitle());
    }

}
