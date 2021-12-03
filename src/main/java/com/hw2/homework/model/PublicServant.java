package com.hw2.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "publicservant")
public class PublicServant {
    @Id
    @Column(length = 60)
    private String email;

    @Column(length = 50)
    private String department;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public PublicServant(String email, String department, Users user) {
        this.email = email;
        this.department = department;
        this.user = user;
    }

    public PublicServant(String email, String department) {
        this.email = email;
        this.department = department;
    }


    public PublicServant() {
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    private Users user;
}
