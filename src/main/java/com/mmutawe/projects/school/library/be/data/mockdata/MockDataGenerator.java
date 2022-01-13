package com.mmutawe.projects.school.library.be.data.mockdata;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.mmutawe.projects.school.library.be.data.enums.CardType;
import com.mmutawe.projects.school.library.be.entities.CampusCard;
import com.mmutawe.projects.school.library.be.entities.Student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mmutawe.projects.school.library.be.data.enums.CardType.BRONZE;
import static com.mmutawe.projects.school.library.be.data.enums.CardType.GOLD;
import static com.mmutawe.projects.school.library.be.data.enums.CardType.PLATINUM;
import static com.mmutawe.projects.school.library.be.data.enums.CardType.SILVER;
import static java.lang.Math.abs;

public class MockDataGenerator {
    private static Random random = new Random();
    private static List<Student> students;
    private static List<CampusCard> campusCards;

    static {
        students = new ArrayList<>();
        campusCards = new ArrayList<>();
        generateStudentsAndCampusCardsMockData();
    }

    public static List<Student> getStudentsMockData() {
        return students;
    }

    public static List<CampusCard> getCampusCardsMockData() {
        return campusCards;
    }

    private static void generateStudentsAndCampusCardsMockData() {
        // Testing purpose (Using Faker to generate a fake data, and then, save it to our database)
        Faker faker = new Faker();
        StringBuilder email = new StringBuilder();
        String fname;
        String lname;

        for (int i = 0; i < 100; i++) {
            fname = faker.name().firstName();
            lname = faker.name().lastName();
            email.setLength(0);
            email.append(fname.toLowerCase()).append(".").append(lname.toLowerCase()).append(getRandomDomainName());

            // create a mock data for 100 students
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

            // create a mock data for 100 students campus card
            campusCards.add(
                    new CampusCard(
                            faker.finance().creditCard(CreditCardType.MASTERCARD),
                            getRandomCardType(),
                            students.get(students.size()-1)
                    )
            );
        }
    }

    private static CardType getRandomCardType() {
        switch (abs(random.nextInt()) % 4) {
            case 0:
                return BRONZE;
            case 1:
                return SILVER;
            case 2:
                return GOLD;
            default:
                return PLATINUM;
        }
    }

    private static String getRandomDomainName() {
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
