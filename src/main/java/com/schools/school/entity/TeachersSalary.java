package com.schools.school.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Salary")
public class TeachersSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private double amountReceived;
    private double balanceOwnSchool;
    private Date dateAmountReceived;
    private double requestedInAdverse;
    private String reasonForAdverse;
    private double allowance;
    private String reasonForAllowance;

    public TeachersSalary(String firstName,
                          String midName,
                          String lastName,
                          double amountReceived,
                          double balanceOwnSchool,
                          Date dateAmountReceived,
                          double requestedInAdverse,
                          String reasonForAdverse,
                          double allowance,
                          String reasonForAllowance) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.amountReceived = amountReceived;
        this.balanceOwnSchool = balanceOwnSchool;
        this.dateAmountReceived = dateAmountReceived;
        this.requestedInAdverse = requestedInAdverse;
        this.reasonForAdverse = reasonForAdverse;
        this.allowance = allowance;
        this.reasonForAllowance = reasonForAllowance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public double getBalanceOwnSchool() {
        return balanceOwnSchool;
    }

    public void setBalanceOwnSchool(double balanceOwnSchool) {
        this.balanceOwnSchool = balanceOwnSchool;
    }

    public Date getDateAmountReceived() {
        return dateAmountReceived;
    }

    public void setDateAmountReceived(Date dateAmountReceived) {
        this.dateAmountReceived = dateAmountReceived;
    }

    public double getRequestedInAdverse() {
        return requestedInAdverse;
    }

    public void setRequestedInAdverse(double requestedInAdverse) {
        this.requestedInAdverse = requestedInAdverse;
    }

    public String getReasonForAdverse() {
        return reasonForAdverse;
    }

    public void setReasonForAdverse(String reasonForAdverse) {
        this.reasonForAdverse = reasonForAdverse;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public String getReasonForAllowance() {
        return reasonForAllowance;
    }

    public void setReasonForAllowance(String reasonForAllowance) {
        this.reasonForAllowance = reasonForAllowance;
    }
}