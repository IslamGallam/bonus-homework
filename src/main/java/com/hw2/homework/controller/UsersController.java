package com.hw2.homework.controller;

import com.hw2.homework.model.Users;
import com.hw2.homework.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users",
                this.usersRepository.findAll());
        return "users";
    }

    @GetMapping("/add/users")
    public String addUsers(Model model) {
        UsersForm usersForm = new UsersForm();

        usersForm.add(new Users());
        model.addAttribute("form", usersForm);
        return "add/users";
    }

    @GetMapping("/edit/users")
    public String editUsers(Model model) {
        List<Users> usersList =
                this.usersRepository.findAll();
        UsersForm usersForm = new UsersForm();
        usersForm.setUsers(usersList);
        model.addAttribute("form", usersForm);
        return "edit/users";
    }

    @PostMapping("users/save/0")
    public String saveUsers0(@ModelAttribute UsersForm form, Model model) {
        List<Users> added = form.getUsers();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getEmail().length() > 0) {
                usersRepository.save(added.get(i));
            }
        }

        model.addAttribute("users",
                this.usersRepository.findAll());
        return "redirect:/users";
    }

    @PostMapping("users/save/1")
    public String saveUsers1(@ModelAttribute UsersForm form, Model model) {
        List<Users> added = form.getUsers();
        for (int i = 0; i < added.size(); i++) {
            if (added.get(i).getName().length() > 0) {
                Users users = usersRepository.getById(added.get(i).getEmail());
                users.setName(added.get(i).getName());
                users.setSurname(added.get(i).getSurname());
                users.setPhone(added.get(i).getPhone());
                users.setSalary(added.get(i).getSalary());
                usersRepository.save(users);
            } else {
                usersRepository.deleteById(added.get(i).getEmail());
            }
        }

        model.addAttribute("users",
                this.usersRepository.findAll());
        return "redirect:/users";
    }
}
