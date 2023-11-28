package com.schools.school.controller;

import com.schools.school.entity.Employees;
import com.schools.school.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class Salary {
    private final EmployeesService employeesService;

    @GetMapping("/salaryForm")
    public String salary(Model model) {
        model.addAttribute("employee", new Employees());
        return "salary";
    }

    @PostMapping("/saveSalary")
    public String saveSalary(@ModelAttribute("employee") Employees employees) {
        employeesService.saveEmployees(employees);
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
