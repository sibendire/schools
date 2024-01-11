package com.schools.school.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Installments")
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fees_payment_id", referencedColumnName = "id")
    private FeesPayment feesPayment;

    @Column(name = "installment_amount")
    private double installmentAmount;

    @Column(name = "installment_date")
    private String installmentDate;

    // Constructors, getters, setters, and other methods...

    public Installment() {
    }

    public Installment(FeesPayment feesPayment, double installmentAmount, String installmentDate) {
        this.feesPayment = feesPayment;
        this.installmentAmount = installmentAmount;
        this.installmentDate = installmentDate;
    }

    // Getters, setters, etc.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeesPayment getFeesPayment() {
        return feesPayment;
    }

    public void setFeesPayment(FeesPayment feesPayment) {
        this.feesPayment = feesPayment;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(String installmentDate) {
        this.installmentDate = installmentDate;
    }
}
