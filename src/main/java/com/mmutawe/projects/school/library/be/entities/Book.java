package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Book")
@Table(name = "books")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "book_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String bookName;

    @Column(
            name = "edition",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String edition;

    @Column(
            name = "category",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String category;

    // TODO *** will be updated later to separate entity ***
    @Column(
            name = "author",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String author;

    // TODO *** will be updated later to separate entity ***
    @Column(
            name = "publisher",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String publisher;


    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Student student;

    public Book() {
    }

    public Book(LocalDateTime createdAt, String bookName) {
        this.createdAt = createdAt;
        this.bookName = bookName;
    }

    public Book(LocalDateTime createdAt, String bookName, Student student) {
        this.createdAt = createdAt;
        this.bookName = bookName;
        this.student = student;
    }

    public Book(LocalDateTime createdAt, String bookName, String edition, String category, String author, String publisher, Student student) {
        this.createdAt = createdAt;
        this.bookName = bookName;
        this.edition = edition;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", bookName='" + bookName + '\'' +
                ", edition='" + edition + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", student=" + student +
                '}';
    }
}
