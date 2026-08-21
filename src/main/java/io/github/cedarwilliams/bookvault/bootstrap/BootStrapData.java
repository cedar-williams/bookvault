package io.github.cedarwilliams.bookvault.bootstrap;

import io.github.cedarwilliams.bookvault.model.BookFormat;
import io.github.cedarwilliams.bookvault.model.Edition;
import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.repository.WorkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final WorkRepository workRepository;

    public BootStrapData(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("CommandLineRunner ran!");
        System.out.println(workRepository.count());

        if (workRepository.count() == 0) {
            Work work1 = new Work();
            work1.setTitle("The Magicians");
            work1.setSubtitle("A Novel");
            work1.setFirstPublishedDate("2009");
            Edition work1edition1 = new Edition();
            work1edition1.setTitle("The Magicians");
            work1edition1.setSubtitle("A Novel");
            work1edition1.setPublishedDate("2009");
            work1edition1.setFormat(BookFormat.PAPERBACK);
            work1.addEdition(work1edition1);
            workRepository.save(work1);

            Work work2 = new Work();
            work2.setTitle("The Prince");
            work2.setFirstPublishedDate("1515");
            Edition work2edition1 = new Edition();
            work2edition1.setTitle("The Prince");
            work2edition1.setPublishedDate("1935");
            work2edition1.setFormat(BookFormat.PAPERBACK);
            workRepository.save(work2);
        }
    }
}
