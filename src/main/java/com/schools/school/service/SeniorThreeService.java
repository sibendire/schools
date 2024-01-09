package com.schools.school.service;

import com.schools.school.entity.SeniorThree;


import java.util.List;

public interface SeniorThreeService {
    void saveToSeniorThree(SeniorThree seniorThree);


    List<SeniorThree> getAllSeniorList();
}
