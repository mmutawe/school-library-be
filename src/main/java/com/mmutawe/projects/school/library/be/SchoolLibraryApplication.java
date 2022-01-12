package com.mmutawe.projects.school.library.be;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SchoolLibraryApplication {

    Logger logger = LoggerFactory.getLogger(SchoolLibraryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchoolLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
			Student student1 = new Student(
					"Kuriboh",
					"YuGiOh",
					"kuriboh@gmail.com",
					"1234 street1 dr apt. 1234, Dallas,TX 1234-12345",
					"(123)456-7890",
					LocalDate.of(1999,8,7)
			);

			Student student2 = new Student(
					"Psyduck",
					"Pokemon",
					"psyduck@gmail.com",
					"4444 street2 ave apt. 4444, Dallas,TX 1234-12345",
					"(444)222-4444",
					LocalDate.of(2008,4,4)
			);

			repository.saveAll(Arrays.asList(
					student1,
					student2
			));

            Long studetCount = repository.count();
            logger.info("number of students in the db: " + studetCount);

            List<Student> students = repository.findAllByAgeGreaterThan18().get();
            logger.info("students over age 18: " + students);

            List<Student> studentsDomain = repository.findAllUseEmailDomain("@gmail.com").get();
            logger.info("students use gmail mailing server : " + studentsDomain);

            int deleteCounter = repository.deleteAllUseEmailDomain("@yahoo.com");
            logger.info("The number of students deleted : " + deleteCounter);
        };
    }
}
