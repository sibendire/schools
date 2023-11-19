package com.schools.school.service;

import com.schools.school.entity.SeniorTwo;

import java.util.List;

public interface SeniorTwoService {
    void saveToSeniorTwo(SeniorTwo seniorTwo);


    List<SeniorTwo> getAllSeniorList();
}
