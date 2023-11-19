package com.schools.school.service;

import com.schools.school.entity.SeniorFour;
import com.schools.school.entity.SeniorTwo;

import java.util.List;

public interface SeniorFourService {
    void saveToSeniorFour(SeniorFour seniorFour);


    List<SeniorFour> getAllSeniorList();
}
