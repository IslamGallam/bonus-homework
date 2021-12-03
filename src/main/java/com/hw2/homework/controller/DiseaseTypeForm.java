package com.hw2.homework.controller;

import com.hw2.homework.model.DiseaseType;

import java.util.ArrayList;
import java.util.List;

public class DiseaseTypeForm {
    public List<DiseaseType> diseaseTypes = new ArrayList<>();

    public void add(DiseaseType nw) {
        this.diseaseTypes.add(nw);
    }

    public List<DiseaseType> getDiseaseTypes() {
        return diseaseTypes;
    }

}
