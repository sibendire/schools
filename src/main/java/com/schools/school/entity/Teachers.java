package com.schools.school.entity;


import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "mid_Name")
    private String midName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email",nullable = false, unique = true,length = 45)
    private String email;
    @Column(name = "phone_Number",nullable = false,unique = true,length = 10)
    private String phoneNumber;
    @Column(name = "teachers_Photo")
    private String teachersPhoto;
    @Column(name = "NIN",nullable = false, unique = true, length = 14)
    private String nationalIdentificationNumber;
    @Column(name = "birth_Date")
    private String dateOfBirth;
    @Column(name = "status")
    private String maritalStatus;

    public Teachers() {

    }


    public Teachers(Long id, String firstName, String midName, String lastName, String gender, String email,
                    String phoneNumber, String teachersPhoto, String nationalIdentificationNumber,
                    String dateOfBirth, String maritalStatus) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teachersPhoto = teachersPhoto;
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTeachersPhoto() {
        return teachersPhoto;
    }

    public void setTeachersPhoto(String teachersPhoto) {
        this.teachersPhoto = teachersPhoto;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
