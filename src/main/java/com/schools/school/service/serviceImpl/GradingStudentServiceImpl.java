package com.schools.school.service.serviceImpl;

import com.schools.school.entity.GradingStudent;
import com.schools.school.repository.GradingStudentRepository;
import com.schools.school.service.GradingStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradingStudentServiceImpl implements GradingStudentService {
    private final GradingStudentRepository gradingStudentRepository;

    @Autowired
    public GradingStudentServiceImpl(GradingStudentRepository gradingStudentRepository) {
        this.gradingStudentRepository = gradingStudentRepository;
    }

    @Override
    public GradingStudent saveStudentGrade(GradingStudent gradingStudent) {
        return gradingStudentRepository.save(gradingStudent);
    }

    @Override
    public int getTotalMarks(GradingStudent gradingStudent) {
        return gradingStudent.getChemistry() + gradingStudent.getEnglish() +
                gradingStudent.getBios() + gradingStudent.getCre() + gradingStudent.getFrench();
    }

    @Override
    public GradingStudent calculateGrade(GradingStudent gradingStudent) {
        int totalMarks = getTotalMarks(gradingStudent);

        // Example grading logic (customize based on your grading criteria)
        String grade;
        if (totalMarks >= 80) {
            grade = "A";
        } else if (totalMarks >= 60) {
            grade = "B";
        } else if (totalMarks >= 40) {
            grade = "C";
        } else {
            grade = "F";
        }

        gradingStudent.setGrade(grade);
        return gradingStudent;
    }

    @Override
    public GradingStudent findById(Long studentId) {
        return gradingStudentRepository.findById(studentId).orElse(null);
    }

    @Override
    public GradingStudent updateStudentMarks(GradingStudent gradingStudent) {
        return gradingStudentRepository.save(gradingStudent);
    }

    @Override
    public void deleteMarksById(Long gradingStudentId) {
        gradingStudentRepository.deleteById(gradingStudentId);
    }

    @Override
    public List<GradingStudent> getAllStudents() {
        return gradingStudentRepository.findAll();
    }

    @Override
    public void calculateGradeForStudent(GradingStudent student) {

    }
}
