package com.schools.school.service;

import com.schools.school.entity.SeniorOnePayModel;

import java.util.List;

public interface SeniorOnePayModelService {
    SeniorOnePayModel saveSeniorOneFee(SeniorOnePayModel seniorOnePayModel);
    List<SeniorOnePayModel> allSeniorStudentPaid(String one);
}
