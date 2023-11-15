package com.schools.school.service;

import com.schools.school.entity.SeniorOne;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface SeniorOneService {
    static void saveToSeniorOne(SeniorOne seniorOne) {
    }

    SeniorOne save(SeniorOne seniorOne);
    List<SeniorOne> getAllSeniorList();
}
