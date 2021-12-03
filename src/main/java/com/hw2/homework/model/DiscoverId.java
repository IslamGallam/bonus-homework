package com.hw2.homework.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class DiscoverId implements Serializable {
    @Column(length = 50)
    private String cname;
    @Column(length = 50)
    private String disease_code;

    public DiscoverId(String cname, String disease_code) {
        this.cname = cname;
        this.disease_code = disease_code;
    }

    public DiscoverId() {
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
