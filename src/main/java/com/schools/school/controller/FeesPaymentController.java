package com.schools.school.controller;

import com.schools.school.entity.FeesPayment;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FeesPaymentController {
    private final FeesPaymentService feesPaymentService;

    @Autowired
    public FeesPaymentController(FeesPaymentService feesPaymentService) {
        this.feesPaymentService = feesPaymentService;
    }

    @GetMapping("/all")
    public List<FeesPayment> getAllFeesPayments() {
        return feesPaymentService.getAllFeesPayments();
    }

    @GetMapping("/{id}")
    public FeesPayment getFeesPaymentById(@PathVariable Long id) {
        return feesPaymentService.getFeesPaymentById(id);
    }
    @GetMapping("/paymentForm")
    public String showPaymentForm(Model model) {
        model.addAttribute("payment", new FeesPayment());
        return "payment";
    }

    @PostMapping("/saveFees")
    public String saveFeesPayment(@ModelAttribute FeesPayment feesPayment) {
        feesPaymentService.saveFeesPayment(feesPayment);
        return "redirect:/fees/list";
    }
    @GetMapping("/fees/list")
    public String listStudentPayment(Model model){
        model.addAttribute("payment",feesPaymentService.getAllFeesPayments());
        return "list_payment";
    }

    @PutMapping("/update")
    public String updateFeesPayment(@RequestBody FeesPayment feesPayment) {
        feesPaymentService.updateFeesPayment(feesPayment);
        return "updated_fees";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFeesPayment(@PathVariable Long id) {
        feesPaymentService.deleteFeesPayment(id);
    }

    @GetMapping("/balance")
    public double calculateFeeBalance(@RequestParam String firstName, @RequestParam String minName, @RequestParam String lastName) {
        return feesPaymentService.calculateFeeBalanceForStudent(firstName, minName, lastName);
    }
}
