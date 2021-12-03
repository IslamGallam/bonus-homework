package com.hw2.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @Column(length = 50)
    private String disease_code;

    @Column(length = 20)
    private String pathogen;

    @Column(length = 140)
    private String description;

    public Disease() {
        diseaseType = new DiseaseType();
    }

    public String getDisease_code() {
        return disease_code;
    }

    public void setDisease_code(String disease_code) {
        this.disease_code = disease_code;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return diseaseType.getId();
    }

    public Disease(String disease_code, String pathogen, String description) {
        this.disease_code = disease_code;
        this.pathogen = pathogen;
        this.description = description;
        this.diseaseType = new DiseaseType();
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Discover getDiscover() {
        return discover;
    }

    public void setDiscover(Discover discover) {
        this.discover = discover;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private DiseaseType diseaseType;

    @OneToOne(mappedBy = "disease", cascade = CascadeType.ALL)
    private Discover discover;
}
