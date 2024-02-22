package com.schools.school.service.serviceImpl;

import com.schools.school.entity.FeesPayment;
import com.schools.school.entity.Installment;
import com.schools.school.repository.FeesPaymentRepository;
import com.schools.school.repository.InstallmentRepository;
import com.schools.school.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class FeesPaymentServiceImpl implements FeesPaymentService {
    private final FeesPaymentRepository feesPaymentRepository;
    private final InstallmentRepository installmentRepository;
    private static final double TOTAL_FEES_LIMIT = 1_000_000.00;

    @Autowired
    public FeesPaymentServiceImpl(FeesPaymentRepository feesPaymentRepository,
                                  InstallmentRepository installmentRepository) {
        this.feesPaymentRepository = feesPaymentRepository;
        this.installmentRepository = installmentRepository;
    }

    @Override
    public double calculateFeeBalanceForStudent(Long feesPaymentId, double installmentAmount) {
        FeesPayment feesPayment = feesPaymentRepository.findById(feesPaymentId).orElseThrow(()
                -> new IllegalArgumentException("Invalid fees payment ID"));

        double currentFeesPaid = feesPayment.getFeesPaid();

        // Check if adding the installment exceeds the total fee limit
        if (currentFeesPaid + installmentAmount > TOTAL_FEES_LIMIT) {
            throw new IllegalArgumentException("Payment limit exceeded. Cannot make further payments.");
        }

        currentFeesPaid += installmentAmount;
        feesPayment.setFeesPaid(currentFeesPaid);

        // Recalculate the feeBalance after adding the installment
        double feeBalance = feesPayment.getTotalFees() - currentFeesPaid;
        feesPayment.setFeeBalance(feeBalance);

        Installment installment = new Installment();
        installment.setFeesPayment(feesPayment);
        installment.setInstallmentAmount(installmentAmount);

        // Ensure the Instant object is not null before using it
        if (installment.getInstallmentDate() != null) {
            installment.setInstallmentDate(String.valueOf(Instant.now().toEpochMilli())); // Assuming the date is being stored as epoch millis
        } else {
            System.err.println("Instant object is null!"); // Log an error or handle it as per your application's requirement
        }

        installmentRepository.save(installment);
        feesPaymentRepository.save(feesPayment);

        return feeBalance;  // Return the updated feeBalance after the installment
    }


//    @Override
//    public double calculateFeeBalanceForStudent(Long feesPaymentId, double installmentAmount) {
//        FeesPayment feesPayment = feesPaymentRepository.findById(feesPaymentId).orElseThrow(() -> new IllegalArgumentException("Invalid fees payment ID"));
//
//        double currentFeesPaid = feesPayment.getFeesPaid();
//
//        // Check if adding the installment exceeds the total fee limit
//        if (currentFeesPaid + installmentAmount > TOTAL_FEES_LIMIT) {
//            throw new IllegalArgumentException("Payment limit exceeded. Cannot make further payments.");
//        }
//
//        currentFeesPaid += installmentAmount;
//        feesPayment.setFeesPaid(currentFeesPaid);
//
//        Installment installment = new Installment();
//        installment.setFeesPayment(feesPayment);
//        installment.setInstallmentAmount(installmentAmount);
//        installment.setInstallmentDate(String.valueOf(Date.from(null)));
//
//        installmentRepository.save(installment);
//        feesPaymentRepository.save(feesPayment);
//
//        return TOTAL_FEES_LIMIT - currentFeesPaid;  // Return the remaining balance after the installment
//    }


    @Override
    public List<FeesPayment> getAllFeesPayments(String keyword) {
        if (keyword != null){
            return feesPaymentRepository.search(keyword);
        }
        return(List<FeesPayment>) feesPaymentRepository.findAll();
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


//    @Override
//    public void updateFeesPayment(FeesPayment feesPayment) {
//
//    }

    @Override
    public void updateFeesPayment(long id, FeesPayment feesPayment) {
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
        if (!feesPaymentRepository.existsById(id)) {
            throw new IllegalArgumentException("No payment made by the id");
        }
        feesPaymentRepository.deleteById(id);
    }

    @Override
    public List<FeesPayment> getBalance(double feeBalance) {
        return  feesPaymentRepository.findAll();
    }

    @Override
    public void calculateFeeBalanceForStudent(Installment installment) {

    }
}
