package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.*;

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
            length = 32
    )
    private String cardNumber;

    @Column(
            name = "card_type",
            nullable = false
    )
    private CardType cardType;

    public CampusCard() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
             name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;

    public CampusCard(String cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }


}

enum CardType {
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM
}