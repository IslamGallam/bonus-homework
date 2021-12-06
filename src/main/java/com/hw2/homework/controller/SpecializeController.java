package com.hw2.homework.controller;

import com.hw2.homework.model.Specialize;
import com.hw2.homework.repository.SpecializeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpecializeController {
    @Autowired
    SpecializeRepository specializeRepository;

    @GetMapping("specialize")
    public String getSpecialize(Model model) {
        model.addAttribute("specialize",
                this.specializeRepository.findAll());
        return "specialize";
    }

    @GetMapping("/add/specialize")
    public String addSpecialize(Model model) {
        SpecializeForm specializeForm = new SpecializeForm();

        specializeForm.add(new Specialize());
        model.addAttribute("form", specializeForm);
        return "add/specialize";
    }

    @GetMapping("/edit/specialize")
    public String editSpecialize(Model model) {
        List<Specialize> specializeList =
                this.specializeRepository.findAll();
        SpecializeForm specializeForm = new SpecializeForm();
        specializeForm.setSpecializeList(specializeList);
        model.addAttribute("form", specializeForm);
        return "edit/specialize";
    }

    @PostMapping("specialize/save/0")
    public String saveSpecialize0(@ModelAttribute SpecializeForm form, Model model) {
        List<Specialize> added = form.getSpecializeList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getEmail().length() > 0 &&
                    added.get(i).getId() >= 0) {
                specializeRepository.save(added.get(i));
            }
        }

        model.addAttribute("specialize",
                this.specializeRepository.findAll());
        return "redirect:/specialize";
    }

    /*@PostMapping("specialize/save/1")
    public String saveSpecialize1(@ModelAttribute SpecializeForm form, Model model) {
        List<Specialize> added = form.getSpecializeList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDepartment().length() > 0) {
                Specialize specialize = specializeRepository.getById(added.get(i).getEmail());
                specialize.setDepartment(added.get(i).getDepartment());
                specializeRepository.save(specialize);
            } else {
                specializeRepository.deleteById(added.get(i).getEmail());
            }
        }

        model.addAttribute("specialize",
                this.specializeRepository.findAll());
        return "redirect:/specialize";
    }*/
}
