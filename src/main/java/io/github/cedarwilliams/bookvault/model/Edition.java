package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an edition of a {@link Work}.
 */
@Entity
@Table(name = "edition")
@Getter
@Setter
@NoArgsConstructor
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "published_date")
    private String publishedDate;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    @OneToMany(mappedBy = "edition")
    private List<Isbn> isbns = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "edition_author",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "edition_publisher",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private List<Publisher> publishers = new ArrayList<>();

}
