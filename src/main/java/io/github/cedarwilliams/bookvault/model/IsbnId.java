package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Represents the composite primary key for {@link Isbn} and holds its data.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class IsbnId implements Serializable {

    private int editionId;
    private String isbn;

}
