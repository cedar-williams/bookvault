package io.github.cedarwilliams.bookvault.repository;

import io.github.cedarwilliams.bookvault.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> findAll();
    List<Work> findByTitle(String title);

}
