package com.hw2.homework.controller;

import com.hw2.homework.model.Disease;

import java.util.ArrayList;
import java.util.List;

public class DiseaseForm {
    List<Disease> diseases = new ArrayList<>();

    public void add(Disease disease) {
        diseases.add(disease);
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }
}
