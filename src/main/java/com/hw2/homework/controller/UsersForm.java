package com.hw2.homework.controller;

import com.hw2.homework.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersForm {
    List<Users> users = new ArrayList<>();

    public void add(Users user) {
        users.add(user);
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Users> getUsers() {
        return users;
    }
}
