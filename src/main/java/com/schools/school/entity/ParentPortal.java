package com.schools.school.entity;


import javax.persistence.*;

@Entity
@Table(name = "Parents")
public class ParentPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
//    private List<StudentRegistration> students;

    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "mid_Name")
    private String midName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "email",nullable = false, unique = true,length = 45)
    private String email;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "photo",nullable = false,unique = true,length = 10)
    private String parentPhoto;
    @Column(name = "nin",nullable = false, unique = true,length = 14)
    private String nationalIdentificationNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "address")
    private String address;
    @Column(name = "sub_County")
    private String subCounty;
    @Column(name = "home_District")
    private String homeDistrict;
//    @OneToMany(mappedBy = "gender")
//    private List<StudentRegistration> studentRegistrations;

    public ParentPortal() {
    }

    public ParentPortal(Long id, String firstName, String midName, String lastName, String email,
                        String phoneNumber, String parentPhoto, String nationalIdentificationNumber, String gender,
                        String occupation, String address, String subCounty, String homeDistrict) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.parentPhoto = parentPhoto;
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.gender = gender;
        this.occupation = occupation;
        this.address = address;
        this.subCounty = subCounty;
        this.homeDistrict = homeDistrict;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getParentPhoto() {
        return parentPhoto;
    }

    public void setParentPhoto(String parentPhoto) {
        this.parentPhoto = parentPhoto;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubCounty() {
        return subCounty;
    }

    public void setSubCounty(String subCounty) {
        this.subCounty = subCounty;
    }

    public String getHomeDistrict() {
        return homeDistrict;
    }

    public void setHomeDistrict(String homeDistrict) {
        this.homeDistrict = homeDistrict;
    }
}