package com.schools.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private ParentPortal parent;
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
    @Column(name = "Gender")
    private String studentGender;
    @Column(name = "Class")
    private String studentClass;
    @Column(name = "Fees")
    private double feesToBeePaid;
    @Column(name = "Health_Record")
    private String studentHealthRecord;
    @Column(name = "school_Name")
    private String formerSchoolName;
    @Column(name = "reason")
    private String reasonWhyChangedSchool;
    @Column(name = "performance_records")
    private String formerSchoolPerformanceRecords;
    @Column(name = "Photo")
    private String studentPhoto;
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
            String studentGender,
            String studentClass,
            double feesToBeePaid,
            String studentHealthRecord,
            String formerSchoolName, String reasonWhyChangedSchool, String formerSchoolPerformanceRecords,
            String studentPhoto,
            String studentHomeAddress,
            String studentSubCounty,
            String studentDistrict) {

        this.studentFirstName = studentFirstName;
        this.studentMidName = studentMidName;
        this.studentLastName = studentLastName;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentNationalIdentificationNumberNIN = studentNationalIdentificationNumberNIN;
        this.studentGender = studentGender;
        this.studentClass = studentClass;
        this.feesToBeePaid = feesToBeePaid;
        this.studentHealthRecord = studentHealthRecord;
        this.formerSchoolName = formerSchoolName;
        this.reasonWhyChangedSchool = reasonWhyChangedSchool;
        this.formerSchoolPerformanceRecords = formerSchoolPerformanceRecords;
        this.studentPhoto = studentPhoto;
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

    public String getFormerSchoolName() {
        return formerSchoolName;
    }

    public void setFormerSchoolName(String formerSchoolName) {
        this.formerSchoolName = formerSchoolName;
    }

    public String getReasonWhyChangedSchool() {
        return reasonWhyChangedSchool;
    }

    public void setReasonWhyChangedSchool(String reasonWhyChangedSchool) {
        this.reasonWhyChangedSchool = reasonWhyChangedSchool;
    }

    public String getFormerSchoolPerformanceRecords() {
        return formerSchoolPerformanceRecords;
    }

    public void setFormerSchoolPerformanceRecords(String formerSchoolPerformanceRecords) {
        this.formerSchoolPerformanceRecords = formerSchoolPerformanceRecords;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
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