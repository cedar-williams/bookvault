package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for {@link Author} entities.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByOrderByNameDesc();
}
