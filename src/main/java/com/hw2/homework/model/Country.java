package com.hw2.homework.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(length = 50)
    private String cname;
    @Column
    private BigInteger population;

    public Country() {
    }

    public Country(String cname, BigInteger population) {
        this.cname = cname;
        this.population = population;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Discover> discoverSet = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Record> records = new HashSet<>();
}
