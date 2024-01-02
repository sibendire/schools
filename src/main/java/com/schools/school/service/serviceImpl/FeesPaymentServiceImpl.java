package com.schools.school.service.serviceImpl;

import com.schools.school.entity.FeesPayment;
import com.schools.school.repository.FeesPaymentRepository;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public double calculateFeeBalanceForStudent(FeesPayment feesPayment) {
        double feesPaid = feesPayment.getFeesPaid();
        double deduction = 1000000.00;
        double feeBalance = feesPaid - deduction;
        feesPayment.setFeeBalance(feeBalance);
      feesPaymentRepository.save(feesPayment);
        return feesPaid;
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
    public FeesPayment saveFees(FeesPayment feesPayment) {
     return feesPaymentRepository.save(feesPayment);
    }


    @Override
    public void updateFeesPayment(FeesPayment feesPayment) {

    }

    @Override
    public void updateFeesPayment(@PathVariable long id, FeesPayment feesPayment) {
        FeesPayment existingPayment = feesPaymentRepository.findById(id).get();
        existingPayment.setFirstName(feesPayment.getFirstName());
        existingPayment.setMinName(feesPayment.getMinName());
        existingPayment.setLastName(feesPayment.getLastName());
        existingPayment.setClassRoom(feesPayment.getClassRoom());
        existingPayment.setFeesOfPayment(feesPayment.getFeesOfPayment());
        existingPayment.setFeesPaid(feesPayment.getFeesPaid());
        existingPayment.setFeeBalance(feesPayment.getFeeBalance());
        feesPaymentRepository.save(existingPayment);
    }

    @Override
    public void deleteFeesPayment(Long id) {
        if (!feesPaymentRepository.existsById(id)){
            throw new IllegalArgumentException("No payment made by the id");
        }
        feesPaymentRepository.deleteById(id);
    }

    @Override
    public List<FeesPayment> getBalance(double feeBalance) {
        return null;
    }
}
