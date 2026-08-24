package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Publisher} entities.
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
