package com.mmutawe.projects.school.library.be;

import com.mmutawe.projects.school.library.be.data.mockdata.MockDataGenerator;
import com.mmutawe.projects.school.library.be.repositories.CampusCardRepository;
import com.mmutawe.projects.school.library.be.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolLibraryApplication {
//    Logger logger = LoggerFactory.getLogger(SchoolLibraryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchoolLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository, CampusCardRepository campusCardRepository) {
        return args -> {

            campusCardRepository.saveAll(MockDataGenerator.getCampusCardsMockData());

            studentRepository.saveAll(MockDataGenerator.getStudentsMockData());

        };
    }
}
