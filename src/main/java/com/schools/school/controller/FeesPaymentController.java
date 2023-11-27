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
        model.addAttribute("payments", new FeesPayment());
        return "payment";
    }

    @PostMapping("/saveFees")
    public ResponseEntity<ResponseDTO> saveFeesPayment(@ModelAttribute FeesPayment feesPayment) {
        try {
            FeesPayment savedPayment = feesPaymentService.saveFees(feesPayment);

            // Calculate total fees paid and fee balance for the student
            double totalFeesPaid = feesPaymentService.calculateTotalFeesPaidByStudent(
                    feesPayment.getFirstName(), feesPayment.getMinName(), feesPayment.getLastName());

            double feeBalance = feesPaymentService.calculateFeeBalanceForStudent(
                    feesPayment.getFirstName(), feesPayment.getMinName(), feesPayment.getLastName());

            // You can include these values in the response or perform further actions

            ResponseDTO responseDTO = new ResponseDTO("Payment saved successfully", savedPayment);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = new ResponseDTO("Error saving payment", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
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
