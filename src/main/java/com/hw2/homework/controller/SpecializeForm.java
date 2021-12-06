package com.hw2.homework.controller;

import com.hw2.homework.model.Specialize;

import java.util.ArrayList;
import java.util.List;

public class SpecializeForm {
    List<Specialize> specializeList = new ArrayList<>();

    public void add(Specialize specialize) {
        specializeList.add(specialize);
    }

    public void setSpecializeList(List<Specialize> specializeList) {
        this.specializeList = specializeList;
    }

    public List<Specialize> getSpecializeList() {
        return specializeList;
    }
}
