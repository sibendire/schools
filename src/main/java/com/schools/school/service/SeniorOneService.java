package com.schools.school.service;

import com.schools.school.entity.SeniorOne;

import java.util.List;

public interface SeniorOneService {


    void saveToSeniorOne(SeniorOne seniorOne);


    List<SeniorOne> getAllSeniorList();
    SeniorOne updateSeniorOne(SeniorOne seniorOne);
    SeniorOne getSeniorOneById(Long id);
    void deleteSeniorOneById(Long id);

    boolean existById(Long id);
}
