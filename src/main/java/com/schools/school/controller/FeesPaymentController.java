package com.schools.school.controller;

import com.schools.school.entity.FeesPayment;
import com.schools.school.entity.ResponseDTO;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/")
public class FeesPaymentController {
    @Autowired
    private final FeesPaymentService feesPaymentService;


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
        model.addAttribute("payments", new FeesPayment());
        return "payment";
    }

    @PostMapping("/saveFees")
    public String saveFeesPayment(@ModelAttribute FeesPayment feesPayment, Model model) {
        try {
            // Save fees payment
            FeesPayment savedPayment = feesPaymentService.saveFees(feesPayment);

            // Calculate total fees paid and fee balance
            double totalFeesPaid = feesPaymentService.calculateTotalFeesPaidByStudent(
                    feesPayment.getFirstName(), feesPayment.getMinName(), feesPayment.getLastName());

            double feeBalance = feesPaymentService.calculateFeeBalanceForStudent(
                    feesPayment.getFirstName(), feesPayment.getMinName(), feesPayment.getLastName());

            // Add the calculated values to the model for display (optional)
            model.addAttribute("totalFeesPaid", totalFeesPaid);
            model.addAttribute("feeBalance", feeBalance);

            // Redirect to a success page with calculated values (modify the template name as needed)
            return "successPage";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for further analysis

            // Add an error message to the model (optional)
            model.addAttribute("errorMessage", "An error occurred while processing the fees payment.");

            // Redirect to an error page (modify the template name as needed)
            return "errorPage";
        }
    }

    @GetMapping("/fees/list")
    public String listStudentPayment(Model model){
        model.addAttribute("payments",feesPaymentService.getAllFeesPayments());
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

//    @GetMapping("/balance")
//    public double calculateFeeBalance() {
//        return feesPaymentService.calculateFeeBalanceForStudent(firstName, minName, lastName);
//    }

}
