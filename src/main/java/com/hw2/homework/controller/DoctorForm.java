package com.hw2.homework.controller;

import com.hw2.homework.model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DoctorForm {
    List<Doctor> doctors = new ArrayList<>();

    public void add(Doctor doctor) {
        doctors.add(doctor);
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
