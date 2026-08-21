package io.github.cedarwilliams.bookvault.service;

import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final WorkRepository workRepository;

    @Autowired
    BookService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

}
