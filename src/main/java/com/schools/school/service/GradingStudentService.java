package com.schools.school.service;

import com.schools.school.entity.GradingStudent;

import java.util.List;

public interface GradingStudentService {
    GradingStudent saveStudentGrade(GradingStudent gradingStudent);

    int getTotalMarks(GradingStudent gradingStudent);

    void calculateGrade(GradingStudent gradingStudent);

    GradingStudent findById(Long studentId);

    GradingStudent updateStudentMarks(GradingStudent gradingStudent);

    void deleteMarksById(Long gradingStudentId);

    List<GradingStudent> getAllStudents();

    void calculateGradeForStudent(GradingStudent student);
}
