package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(
        name = "students",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "student_phone_number_unique",
                        columnNames = "phone_number"
                )
        }
)
public class Student {

    // id: unique & not nullable by default
    @Id
    @Column(
            name = "id",
            updatable = false
    )
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @Column(
            name = "first_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            columnDefinition = "TEXT",
//            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            name = "address",
            columnDefinition = "TEXT",
//            unique = true,
            nullable = false
    )
    private String address;

    @Column(
            name = "phone_number",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String contactNumber;

    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate birthday;

    @OneToOne(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    private CampusCard campusCard;

    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {
                    CascadeType.REMOVE,
                    CascadeType.PERSIST
            }
    )
    private final List<Book> books = new ArrayList<>();

    @ManyToMany(
            cascade = {
                    CascadeType.REMOVE,
                    CascadeType.PERSIST
            }
    )
    @JoinTable(
            name = "enrolment",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    foreignKey = @ForeignKey(name = "enrolment_Student_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "event_id",
                    foreignKey = @ForeignKey(name = "enrolment_event_id_fk")
            )
    )
    private List<Event> events = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String address, String contactNumber, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setStudentCampusCars(CampusCard campusCard) {
        this.campusCard = campusCard;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
