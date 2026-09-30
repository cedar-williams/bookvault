package io.github.cedarwilliams.bookvault.service;

import io.github.cedarwilliams.bookvault.model.Edition;
import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.repository.EditionRepository;
import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * Unit tests for {@link BookService}
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private WorkRepository workRepository;

    @Mock
    private EditionRepository editionRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void saveWork_shouldSaveWorkToRepository() {
        Work work = new Work();

        bookService.saveWork(work);

        verify(workRepository).save(work);
    }


    @Test
    void deleteEdition_shouldDeleteEditionFromRepository() {
        Edition edition = new Edition();

        bookService.deleteEdition(edition);

        verify(editionRepository).delete(edition);
    }

    @Test
    void findWorkById_shouldQueryRepository() {
        Long workId = 1234L;

        bookService.findWorkById(workId);

        verify(workRepository).findById(workId);
    }

    @Test
    void findEditionById_shouldQueryRepository() {
        Long editionId = 1234L;

        bookService.findEditionById(editionId);

        verify(editionRepository).findById(editionId);
    }



}
