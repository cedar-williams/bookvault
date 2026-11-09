package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Represents an ISBN of an {@link Edition}.
 */
@Entity
@Table(name = "isbn")
public class Isbn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isbn_number")
    private String isbn_number;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;


    public Isbn() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn_number;
    }

    public void setIsbn(String isbn) {
        this.isbn_number = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn = (Isbn) o;
        return Objects.equals(isbn_number, isbn.isbn_number) && Objects.equals(edition, isbn.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn_number, edition);
    }
}
