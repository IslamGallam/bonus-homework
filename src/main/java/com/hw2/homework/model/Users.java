package com.hw2.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(length = 60)
    private String email;

    @Column(length = 30)
    private String name;

    @Column(length = 40)
    private String surname;

    public Users(String email, String name, String surname, int salary, String phone) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
    }

    public Users() {
    }

    @Column
    private int salary;

    @Column
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(name = "cname")
    private Country country;

}
