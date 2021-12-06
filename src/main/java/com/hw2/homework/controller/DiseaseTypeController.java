package com.hw2.homework.controller;

import com.hw2.homework.model.DiseaseType;
import com.hw2.homework.repository.DiseaseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
public class DiseaseTypeController {
    int last = 10;
    @Autowired
    private DiseaseTypeRepository diseaseTypeRepository;

    @GetMapping("diseasetype")
    public String getDiseaseType(Model model) {
        model.addAttribute("diseaseTypes",
                this.diseaseTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
        return "diseaseTypes";
    }

    @GetMapping("/add/diseasetype")
    public String addDiseaseType(Model model) {
        DiseaseTypeForm diseaseTypeForm = new DiseaseTypeForm();
            diseaseTypeForm.add(new DiseaseType(""));

            model.addAttribute("form", diseaseTypeForm);
            model.addAttribute("edit", false);
            return "add/diseasetype";
        }


    @GetMapping("/edit/diseasetype")
    public String editDiseaseType(Model model) {
        List<DiseaseType> diseaseTypes =
                this.diseaseTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        DiseaseTypeForm diseaseTypeForm = new DiseaseTypeForm();
        for (DiseaseType item : diseaseTypes) {
            diseaseTypeForm.add(item);
        }
        model.addAttribute("form", diseaseTypeForm);
        return "edit/diseasetype";
    }

    @PostMapping("diseasetype/save/0")
    public String saveDiseaseType0(@ModelAttribute DiseaseTypeForm form, Model model) {
        List<DiseaseType> added = form.getDiseaseTypes();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDescription().length() > 0) {
                added.get(i).setId(last);
                last++;
                diseaseTypeRepository.save(added.get(i));
            }
        }

        model.addAttribute("diseaseTypes",
                this.diseaseTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
        return "redirect:/diseasetype";
    }

    @PostMapping("diseasetype/save/1")
    public String saveDiseaseType1(@ModelAttribute DiseaseTypeForm form, Model model) {
        List<DiseaseType> added = form.getDiseaseTypes();
        for (int i = 0; i < added.size(); i++) {
            System.out.println(added.get(i).getId());
            if (added.get(i).getDescription().length() > 0) {
                DiseaseType ds = diseaseTypeRepository.getById(added.get(i).getId());
                ds.setDescription(added.get(i).getDescription());
                diseaseTypeRepository.save(ds);
            } else {
                diseaseTypeRepository.deleteById(added.get(i).getId());
            }
        }

        model.addAttribute("diseaseTypes",
                this.diseaseTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
        return "redirect:/diseasetype";
    }
}
