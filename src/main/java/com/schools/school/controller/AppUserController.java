package com.schools.school.controller;

import com.schools.school.entity.AppUser;
import com.schools.school.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller

public class AppUserController {
    @Autowired
    private  final AppUserRepository appUserRepository;
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/signup/account")
    public String signupAccount(Model model){
        model.addAttribute("appUser", new AppUser());
        return "signup";
    }
    @PostMapping("/api/save/signup")
    public String saveUser(@ModelAttribute("appUser") AppUser appUser){
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
      appUserRepository.save(appUser);
      return "success_page";
    }
}
