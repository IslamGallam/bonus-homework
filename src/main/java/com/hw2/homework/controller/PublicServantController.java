package com.hw2.homework.controller;

import com.hw2.homework.model.PublicServant;
import com.hw2.homework.repository.PublicServantRepository;
import com.hw2.homework.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublicServantController {
    @Autowired
    PublicServantRepository publicServantRepository;

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("publicservant")
    public String getPublicServant(Model model) {
        model.addAttribute("publicservant",
                this.publicServantRepository.findAll());
        return "publicservant";
    }

    @GetMapping("/add/publicservant")
    public String addPublicServant(Model model) {
        PublicServantForm publicservantForm = new PublicServantForm();

        publicservantForm.add(new PublicServant());
        model.addAttribute("form", publicservantForm);
        return "add/publicservant";
    }

    @GetMapping("/edit/publicservant")
    public String editPublicServant(Model model) {
        List<PublicServant> publicservantList =
                this.publicServantRepository.findAll();
        PublicServantForm publicservantForm = new PublicServantForm();
        publicservantForm.setPublicServantList(publicservantList);
        model.addAttribute("form", publicservantForm);
        return "edit/publicservant";
    }

    @PostMapping("publicservant/save/0")
    public String savePublicServant0(@ModelAttribute PublicServantForm form, Model model) {
        List<PublicServant> added = form.getPublicServantList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getEmail().length() > 0) {
                publicServantRepository.save(added.get(i));
            }
        }

        model.addAttribute("publicservant",
                this.publicServantRepository.findAll());
        return "redirect:/publicservant";
    }

    @PostMapping("publicservant/save/1")
    public String savePublicServant1(@ModelAttribute PublicServantForm form, Model model) {
        List<PublicServant> added = form.getPublicServantList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDepartment().length() > 0) {
                PublicServant publicservant = publicServantRepository.getById(added.get(i).getEmail());
                publicservant.setDepartment(added.get(i).getDepartment());
                publicServantRepository.save(publicservant);
            } else {
                publicServantRepository.deleteById(added.get(i).getEmail());
            }
        }

        model.addAttribute("publicservant",
                this.publicServantRepository.findAll());
        return "redirect:/publicservant";
    }
}
