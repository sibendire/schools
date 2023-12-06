package com.schools.school.service.serviceImpl;

import com.schools.school.entity.Employees;
import com.schools.school.repository.EmployeeRepository;
import com.schools.school.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public void calculateEmployeeSalary(Employees employees) {
        // Set initial balance to 1000000.00
        double initialBalance = 1000000.00;
        employees.setBalance(initialBalance);

        //Then Save the initial balance to the employee
        employeeRepository.save(employees);
    }

    // Method to deduct installment amount
    public void deductInstallment(Long employeeId, double installmentAmount) {
        // Retrieve the employee by ID
        Optional<Employees> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employees employee = optionalEmployee.get();

            // Get the current balance
            double currentBalance = employee.getBalance();

            // Validate installment amount
            if (installmentAmount <= 0 || installmentAmount > currentBalance) {
                // Handle invalid installment amount
                throw new IllegalArgumentException("Invalid installment amount");
            }

            // Deduct the installment amount
            double newBalance = currentBalance - installmentAmount;

            // Update the balance and save the employee entity
            employee.setBalance(newBalance);
            employeeRepository.save(employee);
        } else {
            // Handle the case where the employee is not found
            throw new NoSuchElementException("Employee not found with ID: " + employeeId);
        }
    }


    @Override
    public Employees getBalance(Long id) {
        return employeeRepository.findById( id) .get();
    }
}
