package com.schools.school.service;

import com.schools.school.entity.FeesPayment;
import com.schools.school.entity.Installment;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FeesPaymentService {

   // double calculateFeeBalanceForStudent(FeesPayment feesPayment);

    double calculateFeeBalanceForStudent(Long feesPaymentId, double installmentAmount);

    List<FeesPayment> getAllFeesPayments(String keyword);
    FeesPayment getFeesPaymentById(Long id);
    FeesPayment saveFees(FeesPayment feesPayment);
//    void updateFeesPayment( FeesPayment feesPayment);

    void updateFeesPayment( long id, FeesPayment feesPayment);

    void deleteFeesPayment(Long id);
    List<FeesPayment> getBalance(double feeBalance);


    void calculateFeeBalanceForStudent(Installment installment);
}
