package com.hw2.homework.model;

import org.springframework.core.SpringVersion;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "discover")
public class Discover {
    @EmbeddedId
    private DiscoverId discoverId;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date first_enc_date;

    public Discover(String cname, String disease_code, Date first_enc_date) {
        this.discoverId = new DiscoverId(cname, disease_code);
        this.first_enc_date = first_enc_date;
    }

    public DiscoverId getDiscoverId() {
        return discoverId;
    }

    public void setDiscoverId(DiscoverId discoverId) {
        this.discoverId = discoverId;
    }

    public Discover() {
        this.discoverId = new DiscoverId();
    }

    public Date getFirst_enc_date() {
        return first_enc_date;
    }

    public void setFirst_enc_date(Date first_enc_date) {
        this.first_enc_date = first_enc_date;
    }

    @MapsId("disease_code")
    @OneToOne
    @JoinColumn(name = "disease_code")
    private Disease disease;

    @MapsId("cname")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cname")
    private Country country;
}
