package com.mmutawe.projects.school.library.be;

import com.github.javafaker.Faker;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static java.lang.Math.abs;

@SpringBootApplication
public class SchoolLibraryApplication {

    private Random random = new Random();
    Logger logger = LoggerFactory.getLogger(SchoolLibraryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchoolLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
//            repository.saveAll(getRandomStudents());
            repository
                    .findAll(Sort.by(Sort.Direction.ASC, "firstName"))
                    .forEach(student -> System.out.println(student.getFirstName()));
        };
    }

    private List<Student> getRandomStudents() {
        // Testing purpose (Using Faker to generate a fake data, and then, save it to our database)
        Faker faker = new Faker();
        StringBuilder email = new StringBuilder();
        String fname;
        String lname;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            fname = faker.name().firstName();
            lname = faker.name().lastName();
            email.setLength(0);
            email.append(fname.toLowerCase()).append(".").append(lname.toLowerCase()).append(getRandomDomainName());

            students.add(
                    new Student(
                            fname,
                            lname,
                            ////// faker.internet().emailAddress()
                            email.toString(),
                            faker.address().fullAddress(),
                            faker.phoneNumber().cellPhone(),
                            LocalDate.ofInstant(faker.date().birthday(15, 35).toInstant(), ZoneId.of("CST", ZoneId.SHORT_IDS))
                    )
            );
        }
        return students;
    }

    private String getRandomDomainName() {
        switch (abs(random.nextInt()) % 7) {
            case 0:
                return "@gmail.com";
            case 1:
                return "@yahoo.com";
            case 2:
                return "@Outlook.com";
            case 3:
                return "@icloud.com";
            case 4:
                return "@smu.edu";
            case 5:
                return "@utdallas.edu";
            default:
                return "@udrome.it.edu";
        }
    }
}
