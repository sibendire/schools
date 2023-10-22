package com.schools.school.service.serviceImpl;

import com.schools.school.entity.FeesPayment;
import com.schools.school.repository.FeesPaymentRepository;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class FeesPaymentServiceImpl implements FeesPaymentService {
    private final FeesPaymentRepository feesPaymentRepository;

    @Autowired
    public FeesPaymentServiceImpl(FeesPaymentRepository feesPaymentRepository) {
        this.feesPaymentRepository = feesPaymentRepository;
    }

    @Override
    public double calculateTotalFeesPaidByStudent(String firstName, String minName, String lastName) {
        List<FeesPayment> paymentsByStudent = feesPaymentRepository.findByFirstNameAndMinNameAndLastName(firstName, minName, lastName);

        double totalFeesPaid = 0.0;
        for (FeesPayment payment : paymentsByStudent) {
            totalFeesPaid += payment.getFeesPaid();
        }

        return totalFeesPaid;
    }

    @Override
    public double calculateFeeBalanceForStudent(String firstName, String minName, String lastName) {
        double totalFeesCharged = 800000.0;
        double totalFeesPaid = calculateTotalFeesPaidByStudent(firstName, minName, lastName);
        double feeBalance = totalFeesCharged - totalFeesPaid;
        if (totalFeesPaid != totalFeesCharged) {
            return feeBalance;
        } else
            return totalFeesCharged;
    }

    @Override
    public List<FeesPayment> getAllFeesPayments() {
        return feesPaymentRepository.findAll();
    }

    @Override
    public FeesPayment getFeesPaymentById(Long id) {
        Optional<FeesPayment> optionalFeesPayment = feesPaymentRepository.findById(id);
        return optionalFeesPayment.orElse(null);
    }

    @Override
    public void saveFeesPayment(FeesPayment feesPayment) {
        feesPaymentRepository.save(feesPayment);
    }

    @Override
    public void updateFeesPayment(FeesPayment feesPayment) {
        feesPaymentRepository.save(feesPayment);
    }

    @Override
    public void deleteFeesPayment(Long id) {
        feesPaymentRepository.deleteById(id);
    }
}
