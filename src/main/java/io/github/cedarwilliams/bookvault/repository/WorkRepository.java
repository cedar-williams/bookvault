package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Work} entities.
 */
public interface WorkRepository extends JpaRepository<Work, Long> {

}
