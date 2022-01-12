package com.mmutawe.projects.school.library.be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SchoolLibraryApplication {

    Logger logger = LoggerFactory.getLogger(SchoolLibraryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchoolLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
//			Student student1 = new Student(
//					"Kuriboh",
//					"YuGiOh",
//					"kuriboh@gmail.com",
//					"1234 street1 dr apt. 1234, Dallas,TX 1234-12345",
//					"(123)456-7890",
//					LocalDate.of(1999,8,7)
//			);
//
//			Student student2 = new Student(
//					"Meepo1",
//					"Dota2",
//					"meepo1@gmail.com",
//					"4321 street2 way apt. 4321, Dallas,TX 1234-12345",
//					"(111)222-3333",
//					LocalDate.of(1998,7,6)
//			);
//
//			repository.saveAll(Arrays.asList(
//					student1,
//					student2
//			));

            Long studetCount = repository.count();
            logger.info("number of students in the db: " + studetCount);
//			logger.info(String.valueOf(repository.findAll()));
            for (int i = 1; i <= studetCount; i++) {
                int finalI = i;
                repository
                        .findById((long) i)
                        .ifPresentOrElse(
                                (s) -> logger.info(String.valueOf(s)),
                                () -> logger.error("student with id (" + finalI + ") is not found.")
                        );
            }
        };
    }
}
