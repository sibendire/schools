package com.schools.school.controller;

import com.schools.school.entity.FeesPayment;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/add")
    public String saveFeesPayment(@RequestBody FeesPayment feesPayment) {
        feesPaymentService.saveFeesPayment(feesPayment);
        return "fees_payment";
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
