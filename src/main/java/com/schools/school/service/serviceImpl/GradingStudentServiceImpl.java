package com.schools.school.service.serviceImpl;

import com.schools.school.entity.GradingStudent;
import com.schools.school.repository.GradingStudentRepository;
import com.schools.school.service.GradingStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public long getTotalMarks(GradingStudent gradingStudent) {
        return gradingStudent.getChemistry() + gradingStudent.getEnglish() +
                gradingStudent.getBios() + gradingStudent.getCre() + gradingStudent.getFrench();
    }

    @Override
    public void calculateGrade(GradingStudent gradingStudent) {
        int chemistryScore = gradingStudent.getChemistry();

        if (chemistryScore >= 100) {
            gradingStudent.setChemistry(Integer.parseInt("A"));
        } else if (chemistryScore >= 90) {
            gradingStudent.setChemistry(Integer.parseInt("B"));
        } else if (chemistryScore >= 80) {
            gradingStudent.setChemistry(Integer.parseInt("C"));
        } else if (chemistryScore >= 70) {
            gradingStudent.setChemistry(Integer.parseInt("D"));
        } else if (chemistryScore >= 65) {
            gradingStudent.setChemistry(Integer.parseInt("E"));
        } else {
            gradingStudent.setChemistry(Integer.parseInt("Fail"));
        }
        int englishScore = gradingStudent.getEnglish();
        if (englishScore >= 100) {
            gradingStudent.setEnglish(Integer.parseInt("A"));
        } else if (englishScore >= 90) {
            gradingStudent.setEnglish(Integer.parseInt("B"));
        } else if (englishScore >= 80) {
            gradingStudent.setEnglish(Integer.parseInt("C"));
        } else if (englishScore >= 70) {
            gradingStudent.setEnglish(Integer.parseInt("D"));
        } else if (englishScore >= 65) {
            gradingStudent.setEnglish(Integer.parseInt("E"));
        } else {
            gradingStudent.setEnglish(Integer.parseInt("Fail"));
        }
        int biosScore = gradingStudent.getBios();
        if (biosScore >= 100) {
            gradingStudent.setBios(Integer.parseInt("A"));
        } else if (englishScore >= 90) {
            gradingStudent.setEnglish(Integer.parseInt("B"));
        } else if (englishScore >= 80) {
            gradingStudent.setEnglish(Integer.parseInt("C"));
        } else if (englishScore >= 70) {
            gradingStudent.setEnglish(Integer.parseInt("D"));
        } else if (englishScore >= 65) {
            gradingStudent.setEnglish(Integer.parseInt("E"));
        } else {
            gradingStudent.setBios(Integer.parseInt("Fail"));
        }
        int creScore = gradingStudent.getCre();
        if (creScore>= 100){
            gradingStudent.setCre(Integer.parseInt("A"));
        }else if (creScore>= 90){
            gradingStudent.setCre(Integer.parseInt("B"));
        }else if (creScore>= 80){
            gradingStudent.setCre(Integer.parseInt("C"));
        }else if (creScore>=70){
            gradingStudent.setCre(Integer.parseInt("D"));
        }else if (creScore>=65){
            gradingStudent.setCre(Integer.parseInt("E"));
        }else {
            gradingStudent.setCre(Integer.parseInt("Fail"));
        }
        int frenchScore = gradingStudent.getFrench();
        if(frenchScore>=100){
            gradingStudent.setFrench(Integer.parseInt("A"));
        }else if (frenchScore>= 90){
            gradingStudent.setFrench(Integer.parseInt("B"));
        }else if (frenchScore>= 80){
            gradingStudent.setFrench(Integer.parseInt("C"));
        }else if (frenchScore>= 70){
            gradingStudent.setFrench(Integer.parseInt("D"));
        }else if (frenchScore>=65){
            gradingStudent.setFrench(Integer.parseInt("E"));
        }else {
            gradingStudent.setFrench(Integer.parseInt("Fail"));
        }


    }

    @Override
    public GradingStudent findById(Long studentId) {
        return gradingStudentRepository.findById(studentId).get();
    }

    @Override
    public GradingStudent updateStudentMarks(GradingStudent gradingStudent) {
        return gradingStudentRepository.save(gradingStudent);
    }

    @Override
    public void deleteMarksById(Long id ) {
        gradingStudentRepository.deleteById(id);
    }
}
