package com.hw2.homework.controller;

import com.hw2.homework.model.Doctor;
import com.hw2.homework.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("doctor")
    public String getDoctor(Model model) {
        model.addAttribute("doctor",
                this.doctorRepository.findAll());
        return "doctor";
    }

    @GetMapping("/add/doctor")
    public String addDoctor(Model model) {
        DoctorForm doctorForm = new DoctorForm();

        doctorForm.add(new Doctor());
        model.addAttribute("form", doctorForm);
        return "add/doctor";
    }

    @GetMapping("/edit/doctor")
    public String editDoctor(Model model) {
        List<Doctor> doctorList =
                this.doctorRepository.findAll();
        DoctorForm doctorForm = new DoctorForm();
        doctorForm.setDoctors(doctorList);
        model.addAttribute("form", doctorForm);
        return "edit/doctor";
    }

    @PostMapping("doctor/save/0")
    public String saveDoctor0(@ModelAttribute DoctorForm form, Model model) {
        List<Doctor> added = form.getDoctors();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getEmail().length() > 0) {
                doctorRepository.save(added.get(i));
            }
        }

        model.addAttribute("doctor",
                this.doctorRepository.findAll());
        return "redirect:/doctor";
    }

    @PostMapping("doctor/save/1")
    public String saveDoctor1(@ModelAttribute DoctorForm form, Model model) {
        List<Doctor> added = form.getDoctors();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getDegree().length() > 0) {
                Doctor doctor = doctorRepository.getById(added.get(i).getEmail());
                doctor.setDegree(added.get(i).getDegree());
                doctorRepository.save(doctor);
            } else {
                doctorRepository.deleteById(added.get(i).getEmail());
            }
        }

        model.addAttribute("doctor",
                this.doctorRepository.findAll());
        return "redirect:/doctor";
    }
}
