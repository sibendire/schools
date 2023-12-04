package com.schools.school.service.serviceImpl;

import com.schools.school.entity.Teachers;
import com.schools.school.repository.TeachersRepository;
import com.schools.school.service.TeachersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
    @Service
    public class TeachersServiceImpl implements TeachersService {
        private final TeachersRepository teachersRepository;
    @Override
    public Teachers saveTeacher(Teachers teachers) {
        return teachersRepository.save(teachers);
    }

        @Override
        public List<Teachers> getAllTeachers() {
            return teachersRepository.findAll();
        }

//    @Override
//    public Teachers getTeacherByName(String teachers) {
//        return teachersRepository.findByName();
//    }


    @Override
        public Teachers updateTeacherById(Long id) {
            return teachersRepository.save(updateTeacherById(id));
        }

        @Override
        public Teachers getTeacherById(Long id) {
            return teachersRepository.findById(id).get();
        }

        @Override
        public Teachers getTeacherSalaryById(Long id) {
            return teachersRepository.findById(id).get();
        }

        @Override
        public Teachers updateSalaryById(Long id) {
            return teachersRepository.save(updateSalaryById(id));
        }

        @Override
        public List<Teachers> getAllTeachersSalary() {
            return teachersRepository.findAll();
        }

        @Override
        public boolean deleteTeachersById(Long id) {
            teachersRepository.deleteById(id);
            return false;
        }

        @Override
        public long getTeacherBalance(double balance) {
            return teachersRepository.count();
        }
    }

