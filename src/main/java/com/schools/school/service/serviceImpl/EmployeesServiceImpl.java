package com.schools.school.service.serviceImpl;

import com.schools.school.entity.Employees;
import com.schools.school.repository.EmployeeRepository;
import com.schools.school.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employees saveEmployees(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public List<Employees> getEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees updateEmployeesRecords(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public Employees getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteEmployeeRecordById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employees> getByGender() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees existsById(Long id) {
        return employeeRepository.findById(id).get();
    }
}
