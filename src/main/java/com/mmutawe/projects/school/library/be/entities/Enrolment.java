package com.mmutawe.projects.school.library.be.entities;

import com.mmutawe.projects.school.library.be.entities.composite_keys.EnrolmentId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table(name = "enrolments")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId enrolmentId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolement_student_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(
            name = "event_id",
            foreignKey = @ForeignKey(
                    name = "enrolement_event_fk"
            )
    )
    private Event event;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public Enrolment(){
    }

    public Enrolment(Student student, Event event, LocalDateTime createdAt) {
        this.student = student;
        this.event = event;
        this.createdAt = createdAt;
    }

    public Enrolment(EnrolmentId enrolmentId, Student student, Event event, LocalDateTime createdAt) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.event = event;
        this.createdAt = createdAt;
    }

    public EnrolmentId getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(EnrolmentId enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
