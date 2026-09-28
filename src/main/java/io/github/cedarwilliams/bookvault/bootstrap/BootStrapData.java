package io.github.cedarwilliams.bookvault.bootstrap;

import io.github.cedarwilliams.bookvault.model.BookFormat;
import io.github.cedarwilliams.bookvault.model.Edition;
import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class BootStrapData implements CommandLineRunner {

    private final WorkRepository workRepository;

    public BootStrapData(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }


    /**
     * If there's no data populate create startup data for demonstration purposes
     */
    @Override
    public void run(String... args) throws Exception {

        System.out.println("CommandLineRunner ran!");
        System.out.println(workRepository.count());

        if (workRepository.count() == 0) {
            Work work1 = new Work();
            work1.setTitle("The Magicians");
            work1.setSubtitle("A Novel");
            work1.setFirstPublishedDate(LocalDate.of(2009, 8, 11));
            Edition work1edition1 = new Edition();
            work1edition1.setTitle("The Magicians");
            work1edition1.setSubtitle("A Novel");
            work1edition1.setPublishedDate(LocalDate.of(2009, 8, 11));
            work1edition1.setFormat(BookFormat.PAPERBACK);
            work1.addEdition(work1edition1);
            workRepository.save(work1);

            Work work2 = new Work();
            work2.setTitle("The Prince");
            work2.setFirstPublishedDate(LocalDate.of(1513, 1, 1));
            Edition work2edition1 = new Edition();
            work2edition1.setTitle("The Prince");
            work2edition1.setPublishedDate(LocalDate.of(1935, 1, 1));
            work2edition1.setFormat(BookFormat.PAPERBACK);
            workRepository.save(work2);
        }
    }
}
