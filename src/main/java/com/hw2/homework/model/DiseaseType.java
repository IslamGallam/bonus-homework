package com.hw2.homework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diseasetype")
public class DiseaseType {

    @Id
    private int id;
    @Column(length = 140)
    private String description;

    public DiseaseType() {
    }

    public DiseaseType(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "diseaseType", cascade = CascadeType.ALL)
    private Set<Disease> diseases = new HashSet<>();
}
