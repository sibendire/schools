package com.schools.school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GradingStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int chemistry;
    private int english;
    private int bios;
    private int cre;
    private int french;

    public GradingStudent(Long id, int chemistry, int english, int bios, int cre, int french) {
        this.id = id;
        this.chemistry = chemistry;
        this.english = english;
        this.bios = bios;
        this.cre = cre;
        this.french = french;
    }

    public GradingStudent() {

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
}