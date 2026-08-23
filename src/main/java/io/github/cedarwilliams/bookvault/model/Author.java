package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an author.
 */
@Entity
@Table(name = "author")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Edition> editions = new HashSet<>();


    public Author() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Edition> getEdition() {
        return editions;
    }

    public void setEdition(Set<Edition> editions) {
        this.editions = editions;
    }


    public void addEdition(Edition edition) {
        editions.add(edition);
        edition.addAuthor(this);
    }

    public void removeEdition(Edition edition) {
        editions.remove(edition);
        edition.removeAuthor(this);
    }

}
