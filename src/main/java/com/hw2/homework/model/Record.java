package com.hw2.homework.model;

import org.springframework.core.SpringVersion;

import javax.persistence.*;

@Entity
@Table(name = "record")
public class Record {
    @EmbeddedId
    private RecordId recordId;

    @Column
    private int total_deaths;

    @Column
    private int total_patients;

    public Record(String email, String cname, String disease_code, int total_deaths, int total_patients) {
        this.recordId = new RecordId(email, cname, disease_code);
        this.total_deaths = total_deaths;
        this.total_patients = total_patients;
    }

    public RecordId getRecordId() {
        return recordId;
    }

    public void setRecordId(RecordId recordId) {
        this.recordId = recordId;
    }

    public Record() {
        this.recordId = new RecordId();
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
