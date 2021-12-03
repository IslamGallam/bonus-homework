package com.hw2.homework.model;

import javax.persistence.Column;
import java.io.Serializable;

public class RecordId implements Serializable {
    @Column(length = 60)
    private String email;
    @Column(length = 50)
    private String cname;
    @Column(length = 50)
    private String disease_code;

    public RecordId() {
    }

    public RecordId(String email, String cname, String disease_code) {
        this.email = email;
        this.cname = cname;
        this.disease_code = disease_code;
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
}
