package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an ISBN of an {@link Edition}.
 */
@Entity
@Table(name = "isbn")
@Getter
@Setter
@NoArgsConstructor
public class Isbn {

    @EmbeddedId
    private IsbnId isbnId;

    @ManyToOne
    @MapsId("editionId")
    @JoinColumn(name = "edition_id")
    private Edition edition;
}
