package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Edition} entities.
 */
public interface EditionRepository extends JpaRepository<Edition, Long> {

}
