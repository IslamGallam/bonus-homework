package com.hw2.homework.model;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Set;

@Entity
@Table(name = "specialize")
@IdClass(SpecializeId.class)
public class Specialize {

    @Id
    private int id;

    @Id
    private String email;

    public Specialize(int id, String email, DiseaseType diseaseType) {
        this.id = id;
        this.email = email;
        this.diseaseType = diseaseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Specialize() {
    }

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id")
    private DiseaseType diseaseType;

    @MapsId("email")
    @ManyToOne
    @JoinColumn(name = "email")
    private Doctor doctor;
}
