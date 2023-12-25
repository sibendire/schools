package com.schools.school.controller;

import com.schools.school.entity.Employees;
import com.schools.school.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
        employeesService.calculateEmployeeSalary(employees);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String getListPaidStaff(Model model) {
        model.addAttribute("employees",employeesService.getEmployeesList());
       // employeesService.calculateEmployeeSalary(new Employees());
        return "paidList";
    }

    @GetMapping("/pendingLit")
    public String getListOfStaffWithPending() {
        return "list";
    }

    @PostMapping("/save/Salary")
    public String deductInstallment(@RequestParam Long employeeId, @RequestParam double installmentAmount) {
        try {
            employeesService.deductInstallment(employeeId, installmentAmount);
            return "redirect:/list";  // Redirect to the list page after successful deduction
        } catch (IllegalArgumentException e) {
            // Handle invalid installment amount
            // You might want to add a message to inform the user about the error
            return "redirect:/list";
        } catch (NoSuchElementException e) {
            // Handle employee not found
            // You might want to add a message to inform the user about the error
            return "redirect:/list";
        } catch (Exception e) {
            // Handle other unexpected exceptions
            // You might want to log the exception for further analysis
            e.printStackTrace();
            return "redirect:/list";
        }
    }


    // In your controller or a dedicated controller
    @GetMapping("/calculateSalaries")
    public String calculateSalaries() {
        // ...
        List<Employees> employeesList = employeesService.getEmployeesList();
        for (Employees employee : employeesList) {
            employeesService.calculateEmployeeSalary(employee);
        }
        return "redirect:/list";
    }



}
