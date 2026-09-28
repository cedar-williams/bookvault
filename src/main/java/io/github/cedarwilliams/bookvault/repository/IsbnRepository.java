package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Isbn;
import io.github.cedarwilliams.bookvault.model.IsbnId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for {@link Isbn} entities.
 */
public interface IsbnRepository extends JpaRepository<Isbn, IsbnId> {

    Optional<Isbn> findByIsbnIdIsbn(String isbn);

}
