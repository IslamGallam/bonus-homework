package com.hw2.homework.controller;

import com.hw2.homework.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryForm {
    public List<Country> countryList = new ArrayList<>();

    public void add(Country country) {
        countryList.add(country);
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
