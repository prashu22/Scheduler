package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.LoginCredential;
import com.example.ShdlMeet.entity.Users;
import com.example.ShdlMeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String signup(Users users) {
        return "register";
    }


    @PostMapping("/register")
    public String addUser(@Valid Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.register(user);
        model.addAttribute("users",user);
        return "index.html";
    }



    @GetMapping(value = "/signin")
    public String signin(Users users) {
        return "signin";
    }


    @PostMapping("/signin")
    public String addUser(@Valid LoginCredential loginCredential, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signin";
        }
        Users user=userService.login(loginCredential.getEmail(),loginCredential.getPassword());
        //System.out.println(user.getEmail());
        if(user!=null)
            model.addAttribute("users",user);
        return "index.html";
    }

}