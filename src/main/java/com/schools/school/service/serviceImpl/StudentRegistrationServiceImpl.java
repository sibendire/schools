package com.schools.school.service.serviceImpl;

import com.schools.school.entity.StudentRegistration;
import com.schools.school.repository.StudentRegistrationRepository;
import com.schools.school.service.StudentRegistrationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    private final StudentRegistrationRepository studentRegistrationRepository;

    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    @Override
    public StudentRegistration saveStudentInformation(StudentRegistration studentRegistration) {
        // Add validation checks, business logic, and error handling if needed
        return studentRegistrationRepository.save(studentRegistration);
    }

    @Override
    public List<StudentRegistration> getAllStudents() {
        return studentRegistrationRepository.findAll();
    }

    @Override
    public StudentRegistration updateStudentRecord(Long id) {
        return studentRegistrationRepository.save(updateStudentRecord(id));
    }


    @Override
    public StudentRegistration getStudentById(Long id) {
        return studentRegistrationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student record with ID " + id + " not found."));
    }

    @Override
    public void deleteStudentRecordById(Long id) {
        if (!existsById(id)) {
            throw new IllegalArgumentException("Student record with ID " + id + " not found.");
        }
        studentRegistrationRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return studentRegistrationRepository.existsById(id);
    }
}
