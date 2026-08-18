package io.github.cedarwilliams.bookvault.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "first_published_date")
    private String firstPublishedDate;

    @OneToMany(mappedBy = "work")
    private List<Edition> editions = new ArrayList<>();

}
