package com.schools.school.service;

import com.schools.school.entity.FeesPayment;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FeesPaymentService {
    double calculateTotalFeesPaidByStudent(String firstName, String minName, String lastName);

    double calculateFeeBalanceForStudent(String firstName, String minName, String lastName);

    List<FeesPayment> getAllFeesPayments();
    FeesPayment getFeesPaymentById(Long id);
    FeesPayment saveFeesPayment(FeesPayment feesPayment);
    void updateFeesPayment( FeesPayment feesPayment);

    void updateFeesPayment(@PathVariable long id, FeesPayment feesPayment);

    void deleteFeesPayment(Long id);


}
