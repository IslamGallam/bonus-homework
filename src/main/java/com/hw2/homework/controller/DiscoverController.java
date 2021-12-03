package com.hw2.homework.controller;

import com.hw2.homework.model.Discover;
import com.hw2.homework.model.DiscoverId;
import com.hw2.homework.repository.DiscoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DiscoverController {
    @Autowired
    DiscoverRepository discoverRepository;

    @GetMapping("discover")
    public String getDiscover(Model model) {
        model.addAttribute("discover",
                this.discoverRepository.findAll());
        return "discover";
    }

    @GetMapping("/add/discover")
    public String addDiscover(Model model) {
        DiscoverForm discoverForm = new DiscoverForm();

        discoverForm.add(new Discover());
        model.addAttribute("form", discoverForm);
        return "add/discover";
    }

    @GetMapping("/edit/discover")
    public String editDiscover(Model model) {
        List<Discover> discoverList =
                this.discoverRepository.findAll();
        DiscoverForm discoverForm = new DiscoverForm();
        discoverForm.setDiscoverList(discoverList);
        model.addAttribute("form", discoverForm);
        return "edit/discover";
    }

    @PostMapping("discover/save/0")
    public String saveDiscover0(@ModelAttribute DiscoverForm form, Model model) {
        List<Discover> added = form.getDiscoverList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDiscoverId().getCname().length() > 0 &&
            added.get(i).getDiscoverId().getDisease_code().length() > 0) {
                discoverRepository.save(added.get(i));
            }
        }

        model.addAttribute("discover",
                this.discoverRepository.findAll());
        return "redirect:/discover";
    }

    @PostMapping("discover/save/1")
    public String saveDiscover1(@ModelAttribute DiscoverForm form, Model model) {
        List<Discover> added = form.getDiscoverList();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getFirst_enc_date() != null) {
                Discover discover = discoverRepository.getById(added.get(i).getDiscoverId());
                discover.setFirst_enc_date(added.get(i).getFirst_enc_date());
                discoverRepository.save(discover);
            } else {
                discoverRepository.deleteById(added.get(i).getDiscoverId());
            }
        }

        model.addAttribute("discover",
                this.discoverRepository.findAll());
        return "redirect:/discover";
    }
}
