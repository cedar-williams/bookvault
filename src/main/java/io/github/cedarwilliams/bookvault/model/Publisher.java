package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a publisher.
 */
@Entity
@Table(name = "edition")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "publishers")
    private Set<Edition> editions = new HashSet<>();


    public Publisher() {}


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

    public Set<Edition> getEditions() {
        return editions;
    }

    public void setEditions(Set<Edition> editions) {
        this.editions = editions;
    }


    public void addEdition(Edition edition) {
        editions.add(edition);
        edition.addPublisher(this);
    }

    public void removeEdition(Edition edition) {
        editions.remove(edition);
        edition.removePublisher(this);
    }

}
