package com.mmutawe.projects.school.library.be.entities;

import com.mmutawe.projects.school.library.be.data.enums.CardType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "CampusCard")
@Table(
        name = "student_id_cards",
        uniqueConstraints = @UniqueConstraint(
                name = "student_card_number_unique",
                columnNames = "card_number"
        )
)
public class CampusCard {

    @Id
    @SequenceGenerator(
            name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            columnDefinition = "TEXT",
            nullable = false,
            length = 16
    )
    private String cardNumber;

    @Column(
            name = "card_type",
            nullable = false
    )
    private CardType cardType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;

    public CampusCard() {
    }

    public CampusCard(String cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public CampusCard(String cardNumber, CardType cardType, Student student) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.student = student;
    }
}
