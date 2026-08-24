package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Author} entities.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
