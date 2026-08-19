package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a book or other work of writing
 */
@Entity
@Table(name = "work")
@Getter
@Setter
@NoArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "first_published_date")
    private String firstPublishedDate;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Edition> editions = new HashSet<>();


    public void addEdition(Edition edition) {
        editions.add(edition);
        edition.setWork(this);
    }

    public void removeEdition(Edition edition) {
        editions.remove(edition);
        edition.setWork(null);
    }

}
