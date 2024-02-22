package com.schools.school.controller;

import com.schools.school.entity.*;
import com.schools.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

//    @GetMapping("/all")
//    public List<FeesPayment> getAllFeesPayments() {
//        return feesPaymentService.getAllFeesPayments();
//    }

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
        model.addAttribute("balance", balance);
        return "successPage";
    }

    @GetMapping("/fees/list")
    public String listStudentPayment(Model model, @Param("keyword") String keyword) {
        model.addAttribute("payments", feesPaymentService.getAllFeesPayments(keyword));
        model.addAttribute("keyword", keyword);
        return "list_payment";
    }
    //To be checked well


    @RequestMapping("/updates/{id}")
    public String updateFeesPayment(@PathVariable("id") long id,Model model) {
        FeesPayment feesPayment = feesPaymentService.getFeesPaymentById(id);
        model.addAttribute("payments",feesPayment);
        return "update_fees";
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
    public String getAllSeniorOne(Model model, @Param("one") String one) {
        List<SeniorOnePayModel> list = seniorOnePayModelService.allSeniorStudentPaid(one);
        model.addAttribute("payments", list);
        model.addAttribute("one", one);
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
    public String getAllSeniorTwo(Model model, @Param("two") String two) {
        List<SeniorTwoPayModel> list = seniorTwoPayModelService.allSeniorStudentPaid(two);
        model.addAttribute("payments", list);
        model.addAttribute("two", two);
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
    public String getAllSeniorThree(Model model, @Param("three") String three) {
        List<SeniorThreePayModel> list = seniorThreePayModelService.allSeniorStudentPaid(three);
        model.addAttribute("payments", list);
        model.addAttribute("three", three);
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
    public String getAllSeniorFour(Model model, @Param("four") String four) {
        List<SeniorFourPayModel> list = seniorFourPayModelService.allSeniorStudentPaid(four);
        model.addAttribute("payments", list);
        model.addAttribute("four", four);
        return "seniorFourFees_list";
    }
}
