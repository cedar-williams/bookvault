package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * Since the set order is non-deterministic,
     * we construct a set out of order using a LinkedHashSet.
     */
    @Test
    void getAllEditionsSortedByPublishDateDesc_shouldReturnListInOrder() {
        Work work = new Work();
        Edition e1 = new Edition();
        Edition e2 = new Edition();
        Edition e3 = new Edition();

        e1.setPublishedDate(LocalDate.of(2025,1,1));
        e2.setPublishedDate(LocalDate.of(2000,1,1));
        e3.setPublishedDate(LocalDate.of(2005,1,1));

        Set<Edition> editions = new LinkedHashSet<>();
        editions.add(e1);
        editions.add(e2);
        editions.add(e3);

        work.setEditions(editions);

        List<Edition> orderedEditions = List.of(e1, e3, e2);

        assertEquals(orderedEditions, work.getAllEditionsSortedByPublishDateDesc());

    }

}
