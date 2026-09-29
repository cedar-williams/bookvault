package io.github.cedarwilliams.bookvault.bootstrap;

import io.github.cedarwilliams.bookvault.model.*;
import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Seed the database with sample data
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final WorkRepository workRepository;

    public BootStrapData(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (workRepository.count() == 0) {
            // The Magicians
            Work work1 = new Work();
            work1.setTitle("The Magicians");
            work1.setSubtitle("A Novel");
            work1.setFirstPublishedDate(LocalDate.of(2009, 8, 11));
            Edition work1edition1 = new Edition();
            work1edition1.setTitle("The Magicians");
            work1edition1.setSubtitle("A Novel");
            work1edition1.setPublishedDate(LocalDate.of(2009, 8, 11));
            work1edition1.setFormat(BookFormat.PAPERBACK);
            Author author1 = new Author();
            author1.setName("Lev Grossman");
            work1edition1.addAuthor(author1);
            work1.addEdition(work1edition1);
            workRepository.save(work1);

            // The Prince
            Work work2 = new Work();
            work2.setTitle("The Prince");
            work2.setFirstPublishedDate(LocalDate.of(1513, 1, 1));
            Author author_Mach = new Author();
            author_Mach.setName("Niccolò Machiavelli");

            Edition work2edition1 = new Edition();
            work2edition1.setTitle("The Prince");
            work2edition1.setPublishedDate(LocalDate.of(2003, 2, 4));
            work2edition1.setFormat(BookFormat.PAPERBACK);
            Author w2e1a1 = new Author();
            w2e1a1.setName("George Bull");
            work2edition1.addAuthor(w2e1a1);
            Publisher w2e1p1 = new Publisher();
            w2e1p1.setName("Penguin Classics");
            work2edition1.addPublisher(w2e1p1);
            IsbnId w2e1i1 = new IsbnId();
            work2edition1.addAuthor(author_Mach);
            work2.addEdition(work2edition1);

            Edition work2edition2 = new Edition();
            work2edition2.setTitle("The Prince");
            work2edition2.setPublishedDate(LocalDate.of(1992, 5, 17));
            work2edition2.setFormat(BookFormat.PAPERBACK);
            work2edition1.addAuthor(author_Mach);
            work2.addEdition(work2edition2);

            workRepository.save(work2);
        }
    }

}
