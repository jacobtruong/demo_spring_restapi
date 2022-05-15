package com.example.second_attempt.controller;

import com.example.second_attempt.model.Employee;
import com.example.second_attempt.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // Build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Build get all employees REST API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Build get employee by specific ID REST API
    // api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    // Build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        String name = employeeService.getEmployee(id).getFirstName();

        // Deleting employee from db
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>(String.format("Employee %s (ID: %s) deleted successfully!", name, id), HttpStatus.OK);
    }
}
