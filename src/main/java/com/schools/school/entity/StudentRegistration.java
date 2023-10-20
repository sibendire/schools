package com.schools.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_name")
    private String studentFirstName;
    @Column(name = "Mid_name")
    private String studentMidName;
    @Column(name = "Last_name")
    private String studentLastName;
    @Column(name = "Date_of_Birth")
    private String studentDateOfBirth;
    @Column(name = "NIN")
    private String studentNationalIdentificationNumberNIN;
    @Column(name = "Card_number")
    private String studentNationalIdentificationCardNumber;
    @Column(name = "Gender")
    private String studentGender;
    @Column(name = "Class")
    private String studentClass;
    @Column(name = "Fees_to_be_paid")
    private double feesToBeePaid;
    @Column(name = "Health_Record")
    private String studentHealthRecord;
    @Column(name = "Photo")
    private String studentPhoto;
    @Column(name = "Phone_Number")
    private String studentPhoneNumber;
    @Column(name = "Home_Address")
    private String studentHomeAddress;
    @Column(name = "SubCounty")
    private String studentSubCounty;
    @Column(name = "District")
    private String studentDistrict;

    public StudentRegistration() {
    }

    public StudentRegistration(
            String studentFirstName,
            String studentMidName,
            String studentLastName,
            String studentDateOfBirth,
            String studentNationalIdentificationNumberNIN,
            String studentNationalIdentificationCardNumber,
            String studentGender,
            String studentClass,
            double feesToBeePaid,
            String studentHealthRecord, String studentPhoto,
            String studentPhoneNumber, String studentHomeAddress,
            String studentSubCounty,
            String studentDistrict) {

        this.studentFirstName = studentFirstName;
        this.studentMidName = studentMidName;
        this.studentLastName = studentLastName;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentNationalIdentificationNumberNIN = studentNationalIdentificationNumberNIN;
        this.studentNationalIdentificationCardNumber = studentNationalIdentificationCardNumber;
        this.studentGender = studentGender;
        this.studentClass = studentClass;
        this.feesToBeePaid = feesToBeePaid;
        this.studentHealthRecord = studentHealthRecord;
        this.studentPhoto = studentPhoto;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentHomeAddress = studentHomeAddress;
        this.studentSubCounty = studentSubCounty;
        this.studentDistrict = studentDistrict;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentMidName() {
        return studentMidName;
    }

    public void setStudentMidName(String studentMidName) {
        this.studentMidName = studentMidName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(String studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentNationalIdentificationNumberNIN() {
        return studentNationalIdentificationNumberNIN;
    }

    public void setStudentNationalIdentificationNumberNIN(String studentNationalIdentificationNumberNIN) {
        this.studentNationalIdentificationNumberNIN = studentNationalIdentificationNumberNIN;
    }

    public String getStudentNationalIdentificationCardNumber() {
        return studentNationalIdentificationCardNumber;
    }

    public void setStudentNationalIdentificationCardNumber(String studentNationalIdentificationCardNumber) {
        this.studentNationalIdentificationCardNumber = studentNationalIdentificationCardNumber;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentHealthRecord() {
        return studentHealthRecord;
    }

    public void setStudentHealthRecord(String studentHealthRecord) {
        this.studentHealthRecord = studentHealthRecord;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentHomeAddress() {
        return studentHomeAddress;
    }

    public double getFeesToBeePaid() {
        return feesToBeePaid;
    }

    public void setFeesToBeePaid(double feesToBeePaid) {
        this.feesToBeePaid = feesToBeePaid;
    }

    public void setStudentHomeAddress(String studentHomeAddress) {
        this.studentHomeAddress = studentHomeAddress;
    }

    public String getStudentSubCounty() {
        return studentSubCounty;
    }

    public void setStudentSubCounty(String studentSubCounty) {
        this.studentSubCounty = studentSubCounty;
    }

    public String getStudentDistrict() {
        return studentDistrict;
    }

    public void setStudentDistrict(String studentDistrict) {
        this.studentDistrict = studentDistrict;
    }
}