package com.schools.school.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "S2_Fees")
public class SeniorTwoPayModel {
    @Id
    private Long id;
    @Column(name = "class_Room")
    private String classRoom;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "other_Name")
    private String minName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "term")
    private String term;
    @Column(name = "date")
    private String feesOfPayment;
    @Column(name = "amount")
    private double feesPaid;
    @Column(name = "balance")
    private double feeBalance;

    public SeniorTwoPayModel() {
    }

    public SeniorTwoPayModel(Long id, String classRoom,
                             String firstName, String minName,
                             String lastName, String feesOfPayment,
                             double feesPaid, double feeBalance, String term) {
        this.id = id;
        this.classRoom = classRoom;
        this.firstName = firstName;
        this.minName = minName;
        this.lastName = lastName;
        this.term = term;
        this.feesOfPayment = feesOfPayment;
        this.feesPaid = feesPaid;
        this.feeBalance= feeBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMinName() {
        return minName;
    }

    public void setMinName(String minName) {
        this.minName = minName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFeesOfPayment() {
        return feesOfPayment;
    }

    public void setFeesOfPayment(String feesOfPayment) {
        this.feesOfPayment = feesOfPayment;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getFeeBalance() {
        return feeBalance;
    }

    public void setFeeBalance(double feeBalance) {
        this.feeBalance = feeBalance;
    }
}
