package com.schools.school.service.serviceImpl;

import com.schools.school.entity.StudentRegistration;
import com.schools.school.repository.StudentRegistrationRepository;
import com.schools.school.service.StudentRegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    private final StudentRegistrationRepository studentRegistrationRepository;

    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    @Override
    public StudentRegistration saveStudentInformation(StudentRegistration studentRegistration) {
        return studentRegistrationRepository.save(studentRegistration);
    }
    @Override
    public List<StudentRegistration> getAllStudents() {
        return studentRegistrationRepository.findAll();
    }

    @Override
    public StudentRegistration updateStudentRecords(StudentRegistration studentRegistration) {
        return studentRegistrationRepository.save(studentRegistration);
    }

    @Override
    public StudentRegistration getStudentById(Long id) {
        return studentRegistrationRepository.findById(id).get();
    }

    @Override
    public void deleteStudentRecordById(Long id) {
        studentRegistrationRepository.deleteById(id);
    }

    @Override
    public List<StudentRegistration> getByGender() {
        return studentRegistrationRepository.findAll();
    }


}
