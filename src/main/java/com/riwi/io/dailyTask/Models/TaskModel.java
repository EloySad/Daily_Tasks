package com.riwi.io.dailyTask.Models;

import com.riwi.io.dailyTask.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity

@Table(name = "Tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(nullable = false)
    private LocalDate dateCreation;

    @Column(nullable = false)
    private LocalTime timeCreation;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Status status;

    public TaskModel() {
        this.dateCreation = LocalDate.now();
        this.timeCreation = LocalTime.now();
    }

    public TaskModel(Long id, String title, String description, LocalDate dateCreation, LocalTime timeCreation, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.timeCreation = timeCreation;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalTime getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(LocalTime timeCreation) {
        this.timeCreation = timeCreation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreation=" + dateCreation +
                ", timeCreation=" + timeCreation +
                ", status=" + status +
                '}';
    }
}
