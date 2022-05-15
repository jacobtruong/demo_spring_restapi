package com.example.second_attempt.service.impl;

import com.example.second_attempt.exception.ResourceNotFoundException;
import com.example.second_attempt.model.Employee;
import com.example.second_attempt.repository.EmployeeRepository;
import com.example.second_attempt.service.EmployeeService;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "ID", id);
//        }

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // Check if there exists an employee with ID in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // Save existing employees to DB
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        // Check if there exists an employee with ID in DB
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return;
        } else {
            throw new ResourceNotFoundException("Employee", "ID", id);
        }


    }
}
