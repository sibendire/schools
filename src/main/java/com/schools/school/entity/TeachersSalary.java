package com.schools.school.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Salary")
public class TeachersSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "other_Name")
    private String midName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "amount_Paid")
    private double amountReceived;

    @Column(name = "balance")
    private double balanceOwnSchool;

    @Column(name = "date")
    private String dateAmountReceived;

    @Column(name = "adverse_Amount")
    private double requestedInAdverse;

    @Column(name = "reason")
    private String reasonForAdverse;

    @Column(name = "allowance")
    private double allowance;

    @Column(name = "allowance_Reason")
    private String reasonForAllowance;

    public TeachersSalary(String firstName,
                          String midName,
                          String lastName,
                          double amountReceived,
                          double balanceOwnSchool,
                          String dateAmountReceived,
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

    public String getDateAmountReceived() {
        return dateAmountReceived;
    }

    public void setDateAmountReceived(String dateAmountReceived) {
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