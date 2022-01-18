package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SchoolEvent")
@Table(name = "school_events")
public class Event {

    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long id;

    @Column(
            name = "topic",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String topic;

    @Column(
            name = "field",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String field;

    @Column(
            name = "presenter",
            columnDefinition = "TEXT"
    )
    private String presenter;

    @OneToMany(
            mappedBy = "event",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    private List<Enrolment> enrolments= new ArrayList<>();

    public Event() {
    }

    public Event(String topic, String field, String presenter) {
        this.topic = topic;
        this.field = field;
        this.presenter = presenter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", field='" + field + '\'' +
                ", presenter='" + presenter + '\'' +
                '}';
    }
}
