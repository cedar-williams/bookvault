package io.github.cedarwilliams.bookvault.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void getDisplayTitle_noTitleOrSubtitle_shouldReturnWorkTitleAndSubtitle() {
        Work work = new Work();
        work.setTitle("Work Title");
        work.setSubtitle("Work Subtitle");
        Edition edition = new Edition();
        work.addEdition(edition);

        assertEquals("Work Title: Work Subtitle", edition.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_noTitleOrSubtitle_workNoSubtitle_shouldReturnWorkTitleOnly() {
        Work work = new Work();
        work.setTitle("Work Title");
        Edition edition = new Edition();
        work.addEdition(edition);

        assertEquals("Work Title", edition.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_titleNoSubtitle_shouldReturnEditionTitleAndWorkSubtitle() {
        Work work = new Work();
        work.setTitle("Work Title");
        work.setSubtitle("Work Subtitle");
        Edition edition = new Edition();
        edition.setTitle("Edition Title");
        work.addEdition(edition);

        assertEquals("Edition Title: Work Subtitle", edition.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_SubtitleNoTitle_shouldReturnWorkTitleAndEditionSubtitle() {
        Work work = new Work();
        work.setTitle("Work Title");
        work.setSubtitle("Work Subtitle");
        Edition edition = new Edition();
        edition.setSubtitle("Edition Subtitle");
        work.addEdition(edition);

        assertEquals("Work Title: Edition Subtitle", edition.getDisplayTitle());
    }

    @Test
    void getDisplayTitle_EditionHasTitleAndSubtitle_shouldReturnEditionTitleAndSubtitle() {
        Work work = new Work();
        work.setTitle("Work Title");
        work.setSubtitle("Work Subtitle");
        Edition edition = new Edition();
        edition.setTitle("Edition Title");
        edition.setSubtitle("Edition Subtitle");
        work.addEdition(edition);

        assertEquals("Edition Title: Edition Subtitle", edition.getDisplayTitle());
    }

    /**
     * Since the set order is non-deterministic,
     * we construct a set out of order using a LinkedHashSet.
     */
    @Test
    void getAllAuthorsOrderByName_shouldReturnInAlphabeticOrder() {
        Edition edition = new Edition();
        Author a1 = new Author();
        Author a2 = new Author();
        Author a3 = new Author();

        a1.setName("Montgomery Montrose");
        a2.setName("Alistair Ashcombe");
        a3.setName("Reginald Ravenscroft");

        Set<Author> authors = new LinkedHashSet<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);

        edition.setAuthors(authors);

        List<Author> orderedAuthors = List.of(a2, a1, a3);

        assertEquals(orderedAuthors, edition.getAllAuthorsOrderByName());

    }

}
