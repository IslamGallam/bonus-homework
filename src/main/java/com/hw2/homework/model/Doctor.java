package com.hw2.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(length = 60)
    private String email;

    @Column(length = 20)
    private String degree;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Doctor(String email, String degree, Users user) {
        this.email = email;
        this.degree = degree;
        this.user = user;
    }

    public Doctor() {
    }

    @MapsId("email")
    @OneToOne
    @JoinColumn(name = "email")
    private Users user;
}
