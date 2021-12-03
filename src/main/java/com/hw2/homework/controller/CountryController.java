package com.hw2.homework.controller;

import com.hw2.homework.model.Country;
import com.hw2.homework.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("country")
    public String getCountry(Model model) {
        model.addAttribute("countries",
                this.countryRepository.findAll());
        return "country";
    }

    @GetMapping("/add/country")
    public String addCountry(Model model) {
        CountryForm countryForm = new CountryForm();

        countryForm.add(new Country());
        model.addAttribute("form", countryForm);
        return "add/country";
    }

    @GetMapping("/edit/country")
    public String editCountry(Model model) {
        List<Country> countryList =
                this.countryRepository.findAll();
        CountryForm countryForm = new CountryForm();
        countryForm.setCountryList(countryList);
        model.addAttribute("form", countryForm);
        return "edit/country";
    }

    @PostMapping("country/save/0")
    public String saveCountry0(@ModelAttribute CountryForm form, Model model) {
        List<Country> added = form.getCountryList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getCname().length() > 0) {
                countryRepository.save(added.get(i));
            }
        }

        model.addAttribute("countries",
                this.countryRepository.findAll());
        return "redirect:/country";
    }

    @PostMapping("country/save/1")
    public String saveCountry1(@ModelAttribute CountryForm form, Model model) {
        List<Country> added = form.getCountryList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getPopulation() != null) {
                System.out.println(added.get(i).getCname());
                Country country = countryRepository.getById(added.get(i).getCname());
                country.setPopulation(added.get(i).getPopulation());
                countryRepository.save(country);
            } else {
                countryRepository.deleteById(added.get(i).getCname());
            }
        }

        model.addAttribute("countries",
                this.countryRepository.findAll());
        return "redirect:/country";
    }
}
