package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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

    @ManyToMany(
            mappedBy = "events"
    )
    private List<Student> students= new ArrayList<>();

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
