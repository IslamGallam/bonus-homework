package com.hw2.homework.controller;

import com.hw2.homework.model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordForm {
    List<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }
}
