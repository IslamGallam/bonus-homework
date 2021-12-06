package com.hw2.homework.controller;

import com.hw2.homework.model.Record;
import com.hw2.homework.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecordController {
    @Autowired
    RecordRepository recordRepository;

    @GetMapping("record")
    public String getRecord(Model model) {
        model.addAttribute("record",
                this.recordRepository.findAll());
        return "record";
    }

    @GetMapping("/add/record")
    public String addRecord(Model model) {
        RecordForm recordForm = new RecordForm();

        recordForm.add(new Record());
        model.addAttribute("form", recordForm);
        return "add/record";
    }

    @GetMapping("/edit/record")
    public String editRecord(Model model) {
        List<Record> recordList =
                this.recordRepository.findAll();
        RecordForm recordForm = new RecordForm();
        recordForm.setRecords(recordList);
        model.addAttribute("form", recordForm);
        return "edit/record";
    }
    @PostMapping("record/save/0")
    public String saveRecord0(@ModelAttribute RecordForm form, Model model) {
        List<Record> added = form.getRecords();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getRecordId().getEmail().length() > 0 &&
            added.get(i).getRecordId().getCname().length() > 0 &&
            added.get(i).getRecordId().getDisease_code().length() > 0) {
                System.out.println(added.get(i).getRecordId().getCname());
                recordRepository.save(added.get(i));
            }
        }

        model.addAttribute("record",
                this.recordRepository.findAll());
        return "redirect:/record";
    }

    @PostMapping("record/save/1")
    public String saveRecord1(@ModelAttribute RecordForm form, Model model) {
        List<Record> added = form.getRecords();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getTotal_patients() > 0) {
                Record record = recordRepository.getById(added.get(i).getRecordId());
                record.setTotal_deaths(added.get(i).getTotal_deaths());
                record.setTotal_patients(added.get(i).getTotal_patients());
                recordRepository.save(record);
            } else {
                recordRepository.deleteById(added.get(i).getRecordId());
            }
        }

        model.addAttribute("record",
                this.recordRepository.findAll());
        return "redirect:/record";
    }
}
