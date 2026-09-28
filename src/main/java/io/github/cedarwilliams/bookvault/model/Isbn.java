package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;

/**
 * Represents an ISBN of an {@link Edition}.
 */
@Entity
@Table(name = "isbn")
public class Isbn {

    @EmbeddedId
    private IsbnId isbnId;

    @ManyToOne
    @MapsId("editionId")
    @JoinColumn(name = "edition_id")
    private Edition edition;


    public Isbn() {}


    public IsbnId getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(IsbnId isbnId) {
        this.isbnId = isbnId;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

}
