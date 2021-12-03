package com.hw2.homework.controller;

import com.hw2.homework.model.Discover;

import java.util.ArrayList;
import java.util.List;

public class DiscoverForm {
    List<Discover> discoverList = new ArrayList<>();

    public void add(Discover discover) {
        discoverList.add(discover);
    }

    public void setDiscoverList(List<Discover> discoverList) {
        this.discoverList = discoverList;
    }

    public List<Discover> getDiscoverList() {
        return discoverList;
    }
}
