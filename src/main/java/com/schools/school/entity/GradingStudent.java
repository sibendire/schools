package com.schools.school.entity;

import jakarta.persistence.*;


@Entity
public class GradingStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentFirstName;
    private String studentMidName;
    private String studentLastName;
    private int chemistry;
    private int english;
    private int bios;
    private int cre;
    private int french;
    private String grade;

    public GradingStudent() {
    }

    public GradingStudent(Long id, String studentFirstName, String studentMidName, String studentLastName) {
        this.id = id;
        this.studentFirstName = studentFirstName;
        this.studentMidName = studentMidName;
        this.studentLastName = studentLastName;
    }

    public GradingStudent(int chemistry, int english, int bios, int cre, int french, String grade) {
        this.chemistry = chemistry;
        this.english = english;
        this.bios = bios;
        this.cre = cre;
        this.french = french;
        this.grade = grade;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getBios() {
        return bios;
    }

    public void setBios(int bios) {
        this.bios = bios;
    }

    public int getCre() {
        return cre;
    }

    public void setCre(int cre) {
        this.cre = cre;
    }

    public int getFrench() {
        return french;
    }

    public void setFrench(int french) {
        this.french = french;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
}
