package com.schools.school.controller;

import com.schools.school.entity.*;
import com.schools.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeesPaymentController {
    @Autowired


    private final FeesPaymentService feesPaymentService;
    @Autowired

    private final SeniorOnePayModelService seniorOnePayModelService;
    @Autowired
    private final SeniorTwoPayModelService seniorTwoPayModelService;
    @Autowired
    private final SeniorThreePayModelService seniorThreePayModelService;
    @Autowired
    private final SeniorFourPayModelService seniorFourPayModelService;

    private List<FeesPayment> selectedStudent = new ArrayList<>();
    private Long id;

    public FeesPaymentController(FeesPaymentService feesPaymentService,
                                 SeniorOnePayModelService seniorOnePayModelService,
                                 SeniorTwoPayModelService seniorTwoPayModelService,
                                 SeniorThreePayModelService seniorThreePayModelService,
                                 SeniorFourPayModelService seniorFourPayModelService) {
        this.feesPaymentService = feesPaymentService;
        this.seniorOnePayModelService = seniorOnePayModelService;
        this.seniorTwoPayModelService = seniorTwoPayModelService;
        this.seniorThreePayModelService = seniorThreePayModelService;
        this.seniorFourPayModelService = seniorFourPayModelService;
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
    public String saveFeesPayment(@ModelAttribute FeesPayment feesPayment, Installment installment, Model model) {
       FeesPayment savedPayment = feesPaymentService.saveFees(feesPayment);
       double balance = feesPaymentService.calculateFeeBalanceForStudent(savedPayment.getId(),
               installment.getInstallmentAmount());
        model.addAttribute("balance",balance);
        return "successPage";
    }

    @GetMapping("/fees/list")
    public String listStudentPayment(Model model) {
        model.addAttribute("payments", feesPaymentService.getAllFeesPayments());
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

    @RequestMapping("/saveFees/one/{id}")
    public String saveToSeniorOne(@PathVariable("id") Long id) {
        FeesPayment feesPayment = feesPaymentService.getFeesPaymentById(id);
        SeniorOnePayModel seniorOnePayModel = new SeniorOnePayModel(feesPayment.getId(),
                feesPayment.getClassRoom(),
                feesPayment.getFirstName(),
                feesPayment.getMinName(),
                feesPayment.getLastName(),
                feesPayment.getFeesOfPayment(),
                feesPayment.getFeesPaid(),
                feesPayment.getFeeBalance(),
                feesPayment.getTerm());
        seniorOnePayModelService.saveSeniorOneFee(seniorOnePayModel);
        selectedStudent.add(feesPayment);
        return "redirect:/senior1/list";
    }
    @GetMapping("/senior1/list")
    public String getAllSeniorOne(Model model){
        List<SeniorOnePayModel> list = seniorOnePayModelService.allSeniorStudentPaid();
        model.addAttribute("payments",list);
        return "seniorOneFees_list";
    }

    @RequestMapping("/saveFees/two/{id}")
    public String saveToSeniorTwo(@PathVariable("id") Long id) {
        FeesPayment feesPayment = feesPaymentService.getFeesPaymentById(id);
        SeniorTwoPayModel seniorTwoPayModel = new SeniorTwoPayModel(feesPayment.getId(),
                feesPayment.getClassRoom(),
                feesPayment.getFirstName(),
                feesPayment.getMinName(),
                feesPayment.getLastName(),
                feesPayment.getFeesOfPayment(),
                feesPayment.getFeesPaid(),
                feesPayment.getFeeBalance(),
                feesPayment.getTerm());
        seniorTwoPayModelService.saveSeniorTwoFee(seniorTwoPayModel);
        selectedStudent.add(feesPayment);
        return "redirect:/senior2/list";
    }
    @GetMapping("/senior2/list")
    public String getAllSeniorTwo(Model model){
        List<SeniorTwoPayModel> list = seniorTwoPayModelService.allSeniorStudentPaid();
        model.addAttribute("payments",list);
        return "seniorTwoFees_list";
    }
    @RequestMapping("/saveFees/three/{id}")
    public String saveToSeniorThree(@PathVariable("id") Long id) {
        FeesPayment feesPayment = feesPaymentService.getFeesPaymentById(id);
        SeniorThreePayModel seniorThreePayModel = new SeniorThreePayModel(feesPayment.getId(),
                feesPayment.getClassRoom(),
                feesPayment.getFirstName(),
                feesPayment.getMinName(),
                feesPayment.getLastName(),
                feesPayment.getFeesOfPayment(),
                feesPayment.getFeesPaid(),
                feesPayment.getFeeBalance(),
                feesPayment.getTerm());
        seniorThreePayModelService.saveSeniorThreeFee(seniorThreePayModel);
        selectedStudent.add(feesPayment);
        return "redirect:/senior3/list";
    }
    @GetMapping("/senior3/list")
    public String getAllSeniorThree(Model model){
        List<SeniorThreePayModel> list = seniorThreePayModelService.allSeniorStudentPaid();
        model.addAttribute("payments",list);
        return "seniorThreeFees_list";
    }
    @RequestMapping("/saveFees/four/{id}")
    public String saveToSeniorFour(@PathVariable("id") Long id) {
        FeesPayment feesPayment = feesPaymentService.getFeesPaymentById(id);
        SeniorFourPayModel seniorFourPayModel = new SeniorFourPayModel(feesPayment.getId(),
                feesPayment.getClassRoom(),
                feesPayment.getFirstName(),
                feesPayment.getMinName(),
                feesPayment.getLastName(),
                feesPayment.getFeesOfPayment(),
                feesPayment.getFeesPaid(),
                feesPayment.getFeeBalance(),
                feesPayment.getTerm());
        seniorFourPayModelService.saveSeniorFourFee(seniorFourPayModel);
        selectedStudent.add(feesPayment);
        return "redirect:/senior4/list";
    }
    @GetMapping("/senior4/list")
    public String getAllSeniorFour(Model model){
        List<SeniorFourPayModel> list = seniorFourPayModelService.allSeniorStudentPaid();
        model.addAttribute("payments",list);
        return "seniorFourFees_list";
    }
}
