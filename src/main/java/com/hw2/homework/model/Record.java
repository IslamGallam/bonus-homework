package com.hw2.homework.model;

import org.springframework.core.SpringVersion;

import javax.persistence.*;

@Entity
@Table(name = "record")
@IdClass(RecordId.class)
public class Record {
    @Id
    private String email;

    @Id
    private String cname;

    @Id
    private String disease_code;

    @Column
    private int total_deaths;

    @Column
    private int total_patients;

    public Record(String email, String cname, String disease_code, int total_deaths, int total_patients) {
        this.email = email;
        this.cname = cname;
        this.disease_code = disease_code;
        this.total_deaths = total_deaths;
        this.total_patients = total_patients;
    }

    public Record() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDisease_code() {
        return disease_code;
    }

    public void setDisease_code(String disease_code) {
        this.disease_code = disease_code;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    public int getTotal_patients() {
        return total_patients;
    }

    public void setTotal_patients(int total_patients) {
        this.total_patients = total_patients;
    }

    @MapsId("email")
    @ManyToOne
    @JoinColumn(name = "email")
    private PublicServant publicServant;

    @MapsId("cname")
    @ManyToOne
    @JoinColumn(name = "cname")
    private Country country;

    @MapsId("disease_code")
    @ManyToOne
    @JoinColumn(name = "disease_code")
    private Disease disease;
}
