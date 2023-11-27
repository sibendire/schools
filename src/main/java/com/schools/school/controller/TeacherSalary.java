package com.schools.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherSalary {
    @GetMapping("/salaryForm")
    public String salary(Model model) {
        return "salary";
    }

    @PostMapping("/saveSalary")
    public String saveSalary(Model model) {
        return "redirect:/paidList";
    }

    @GetMapping("/list")
    public String getListPaidStaff() {
        return "paidList";
    }

    @GetMapping("/pendingLit")
    public String getListOfStaffWithPending() {
        return "list";
    }

}
