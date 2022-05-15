package com.example.second_attempt.service;

import com.example.second_attempt.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
