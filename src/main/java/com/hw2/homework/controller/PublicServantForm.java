package com.hw2.homework.controller;

import com.hw2.homework.model.PublicServant;

import java.util.ArrayList;
import java.util.List;

public class PublicServantForm {
    List<PublicServant> publicServantList = new ArrayList<>();

    public void add(PublicServant publicServant) {
        publicServantList.add(publicServant);
    }

    public void setPublicServantList(List<PublicServant> publicServantList) {
        this.publicServantList = publicServantList;
    }

    public List<PublicServant> getPublicServantList() {
        return publicServantList;
    }
}
