package com.schools.school.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Fees")
public class FeesPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classRoom;
    private String firstName;
    private String minName;
    private String lastName;
    private String photo;
    private Date feesOfPayment;
    private double feesPaid;
    private double feeBalance;

    public FeesPayment() {
    }

    public FeesPayment(Long id, String classRoom, String firstName, String minName,
                       String lastName, String photo, Date feesOfPayment,
                       double feesPaid, double feeBalance) {
        this.id = id;
        this.classRoom = classRoom;
        this.firstName = firstName;
        this.minName = minName;
        this.lastName = lastName;
        this.photo = photo;
        this.feesOfPayment = feesOfPayment;
        this.feesPaid = feesPaid;
        this.feeBalance = feeBalance;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getFeesOfPayment() {
        return feesOfPayment;
    }

    public void setFeesOfPayment(Date feesOfPayment) {
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