package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the composite primary key for {@link Isbn} and holds its data.
 */
@Embeddable
public class IsbnId implements Serializable {

    private Long editionId;
    private String isbn;


    public IsbnId() {}


    public Long getEditionId() {
        return editionId;
    }

    public void setEditionId(Long editionId) {
        this.editionId = editionId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IsbnId isbnId = (IsbnId) o;
        return Objects.equals(editionId, isbnId.editionId) && Objects.equals(isbn, isbnId.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editionId, isbn);
    }

}
