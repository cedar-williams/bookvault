package io.github.cedarwilliams.bookvault.service;

import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final WorkRepository workRepository;

    @Autowired
    BookService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public List<Work> findAll() {
        return workRepository.findAll();
    }


}
