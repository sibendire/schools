package com.schools.school.service;

import com.schools.school.entity.FeesPayment;

import java.util.List;

public interface FeesPaymentService {
    double calculateTotalFeesPaidByStudent(String firstName, String minName, String lastName);

    double calculateFeeBalanceForStudent(String firstName, String minName, String lastName);

    List<FeesPayment> getAllFeesPayments();
    FeesPayment getFeesPaymentById(Long id);
    void saveFeesPayment(FeesPayment feesPayment);
    void updateFeesPayment(FeesPayment feesPayment);
    void deleteFeesPayment(Long id);


}
