package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an edition of a {@link Work}.
 */
@Entity
@Table(name = "edition")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "format")
    @Enumerated(EnumType.STRING)
    private BookFormat format;

    @ManyToOne(optional = false)
    @JoinColumn(name = "work_id")
    private Work work;

    @OneToMany(
            mappedBy = "edition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Isbn> isbns = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "edition_author",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "edition_publisher",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private Set<Publisher> publishers = new HashSet<>();


    public Edition() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Set<Isbn> getIsbns() {
        return isbns;
    }

    public void setIsbns(Set<Isbn> isbns) {
        this.isbns = isbns;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }


    /** Associates an ISBN with this edition */
    public void addIsbn(Isbn isbn) {
        isbns.add(isbn);
        isbn.setEdition(this);
    }

    /** Disassociates an ISBN from this edition */
    public void removeIsbn(Isbn isbn) {
        isbns.remove(isbn);
        isbn.setEdition(null);
    }

    /** Associates an author with this edition */
    public void addAuthor(Author author) {
        authors.add(author);
        author.getEditions().add(this);
    }

    /** Disassociates an author from this edition */
    public void removeAuthor(Author author) {
        authors.remove(author);
        author.getEditions().remove(this);
    }

    /** Associates a publisher with this edition */
    public void addPublisher(Publisher publisher) {
        publishers.add(publisher);
        publisher.getEditions().add(this);
    }

    /** Disassociates a publisher from this edition */
    public void removePublisher(Publisher publisher) {
        publishers.remove(publisher);
        publisher.getEditions().remove(this);
    }

}
