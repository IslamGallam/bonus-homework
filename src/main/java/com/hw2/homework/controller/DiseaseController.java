package com.hw2.homework.controller;

import com.hw2.homework.model.Country;
import com.hw2.homework.model.Disease;
import com.hw2.homework.repository.DiscoverRepository;
import com.hw2.homework.repository.DiseaseRepository;
import com.hw2.homework.repository.DiseaseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DiseaseController {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @GetMapping("disease")
    public String getDisease(Model model) {
        model.addAttribute("diseases",
                this.diseaseRepository.findAll());
        return "disease";
    }

    @GetMapping("/add/disease")
    public String addDisease(Model model) {
        DiseaseForm diseaseForm = new DiseaseForm();

        diseaseForm.add(new Disease());
        model.addAttribute("form", diseaseForm);
        return "add/disease";
    }

    @GetMapping("/edit/disease")
    public String editDisease(Model model) {
        List<Disease> diseaseList =
                this.diseaseRepository.findAll();
        DiseaseForm diseaseForm = new DiseaseForm();
        diseaseForm.setDiseases(diseaseList);
        model.addAttribute("form", diseaseForm);
        return "edit/disease";
    }

    @PostMapping("disease/save/0")
    public String saveDisease0(@ModelAttribute DiseaseForm form, Model model) {
        List<Disease> added = form.getDiseases();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDisease_code().length() > 0) {
                diseaseRepository.save(added.get(i));
            }
        }

        model.addAttribute("diseases",
                this.diseaseRepository.findAll());
        return "redirect:/disease";
    }

    @PostMapping("disease/save/1")
    public String saveDisease1(@ModelAttribute DiseaseForm form, Model model) {
        List<Disease> added = form.getDiseases();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getPathogen().length() > 0) {
                Disease disease = diseaseRepository.getById(added.get(i).getDisease_code());
                disease.setDescription(added.get(i).getDescription());
                disease.setPathogen(added.get(i).getPathogen());
                disease.setDiseaseType(added.get(i).getDiseaseType());
                diseaseRepository.save(disease);
            } else {
                diseaseRepository.deleteById(added.get(i).getDisease_code());
            }
        }

        model.addAttribute("diseases",
                this.diseaseRepository.findAll());
        return "redirect:/disease";
    }
}
