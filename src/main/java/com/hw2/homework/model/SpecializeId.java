package com.hw2.homework.model;

import javax.persistence.Column;
import java.io.Serializable;

public class SpecializeId implements Serializable {
    private int id;
    @Column(length = 60)
    private String email;

    public SpecializeId() {
    }

    public SpecializeId(int id, String email) {
        this.id = id;
        this.email = email;
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
}
