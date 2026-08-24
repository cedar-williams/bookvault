package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Isbn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Isbn} entities.
 */
public interface IsbnRepository extends JpaRepository<Isbn, Long> {

}
