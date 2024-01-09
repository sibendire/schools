package com.schools.school.service;

import com.schools.school.entity.Employees;

import java.util.List;

public interface EmployeesService {
    Employees saveEmployees(Employees employees);
    List<Employees> getEmployeesList();
    Employees updateEmployeesRecords(Employees employees);
    Employees getEmployeeById(Long id);
    void deleteEmployeeRecordById(Long id);
    List<Employees> getByGender();

    Employees existsById(Long id);
    void calculateEmployeeSalary(Employees employees);
    void deductInstallment(Long employeeId, double installmentAmount);

    Employees getBalance(Long id);

//    void calculateEmployeeSalary(Long employeeId, double balance);
  //  void totalAmountSpentOnSalary(Employees employees);
}
